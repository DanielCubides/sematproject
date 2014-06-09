package sematproject

import org.springframework.dao.DataIntegrityViolationException

class TaskController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[taskInstanceList: session.backlog.tasks, taskInstanceTotal: Task.count()]
	}

	def create(Long id) {
		def backlogInstance = Backlog.get(id)
		[backlogInstance:backlogInstance, taskInstance: new Task(params)]
	}



	def save() {
		def taskInstance = new Task(params)
		if (!taskInstance.save(flush: true)) {
			render(view: "create", model: [taskInstance: taskInstance])
			return
		}
		flash.message = message(code: 'default.created.message', args: [
			message(code: 'task.label', default: 'Task'),
			taskInstance.id
		])
		redirect(action: "addTask", id: taskInstance.id)
	}

	def addTask(Long id){
		def sessionInstance = session.sesion
		def backlog = Backlog.get(session.sesion.id)
		def t1 = Task.get(id)
		backlog.tasks.add(t1)
		session.sesion = Session.get(session.sesion.id)
		redirect(controller:"backlog", action: "ToDo", id: session.sesion.id)
		
	}

	def show(Long id) {
		def backlogInstance = Backlog.get(session.sesion.id)
		def taskInstance = Task.get(id)
		if (!taskInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance:backlogInstance, taskInstance: taskInstance]
	}

	def edit(Long id) {
		def backlogInstance = Backlog.get(session.sesion.id)
		def taskInstance = Task.get(id)
		if (!taskInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance:backlogInstance, taskInstance: taskInstance]
	}

	def update(Long id, Long version) {
		def taskInstance = Task.get(id)
		if (!taskInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (taskInstance.version > version) {
				taskInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'task.label', default: 'Task')] as Object[],
						"Another user has updated this Task while you were editing")
				render(view: "edit", model: [taskInstance: taskInstance])
				return
			}
		}

		taskInstance.properties = params

		if (!taskInstance.save(flush: true)) {
			render(view: "edit", model: [taskInstance: taskInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'task.label', default: 'Task'),
			taskInstance.id
		])
		
		if(taskInstance.state == 0) redirect(controller:"backlog", action: "toDo", id: session.sesion.id)
		if(taskInstance.state == 1) redirect(controller:"backlog", action: "Doing", id: session.sesion.id)
		if(taskInstance.state == 2) redirect(controller:"backlog", action: "Done", id: session.sesion.id)
	}

	def delete(Long id) {
		def taskInstance = Task.get(id)
		if (!taskInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			taskInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'task.label', default: 'Task'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}
