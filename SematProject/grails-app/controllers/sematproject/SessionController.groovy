package sematproject

import org.springframework.dao.DataIntegrityViolationException

class SessionController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def sessionhome(Long id){
		def sessionInstance = Session.get(id)
		
		if (!sessionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
			return
		}
		session.sesion = sessionInstance
		if(sessionInstance.backlog.tasks.size() == 0){
			redirect(controller: "backlog", action: "init", id: sessionInstance.id)
		}else
			redirect(controller: "kernel", action: "show", id: sessionInstance.id)

		[sessionInstance: sessionInstance]
	}
	
	def index() {
		redirect(action: "list", params: params)
	}	
	
	def list() {
		def userInstance = User.get(session.user.id)
		if(session.user == null)
			redirect( action:'login')
		[userInstance: userInstance]
	}
	
	def addMember(Long id){
		def sessionInstance = Session.get(id)
		if(session.user != null && sessionInstance != null){
				new RelUserSesion(sessionInstance, session.user, true).save()
				redirect(action: "sessionhome", id: sessionInstance.id)	
			}
	}

	def create() {
		def sessionInstance = new Session(params)
		
		[sessionInstance: sessionInstance]
	}

	def save() {
		def sessionInstance = new Session(params)
		
		if (!sessionInstance.save(flush: true)) {
			render(view: "create", model: [sessionInstance: sessionInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'session.label', default: 'Session'),
			sessionInstance.id
		])
		sessionInstance.backlog.ProductOwner = session.user.name
		redirect(action: "addMember", id: sessionInstance.id)
	}

	def show(Long id) {
		def sessionInstance = Session.get(id)
		 if (!sessionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
			return
		}

		[sessionInstance: sessionInstance]
	}

	def edit(Long id) {
		def sessionInstance = Session.get(id)
		if (!sessionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
			return
		}

		[sessionInstance: sessionInstance]
	}

	def update(Long id, Long version) {
		def sessionInstance = Session.get(id)
		if (!sessionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (sessionInstance.version > version) {
				sessionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'session.label', default: 'Session')] as Object[],
						"Another user has updated this Session while you were editing")
				render(view: "edit", model: [sessionInstance: sessionInstance])
				return
			}
		}

		sessionInstance.properties = params

		if (!sessionInstance.save(flush: true)) {
			render(view: "edit", model: [sessionInstance: sessionInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'session.label', default: 'Session'),
			sessionInstance.id
		])
		redirect(action: "show", id: sessionInstance.id)
	}

	def delete(Long id) {
		def sessionInstance = Session.get(id)
		if (!sessionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			sessionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'session.label', default: 'Session'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}
