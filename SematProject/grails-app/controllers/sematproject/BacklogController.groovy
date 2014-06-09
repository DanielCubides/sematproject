package sematproject

import org.springframework.dao.DataIntegrityViolationException

class BacklogController {

	static allowedMethods = [save: "POST", update: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	//Pagina principal del backloh del proyecto
	def home(long id){
		def backlogInstance = Backlog.get(id)
		/*//Si el proyecto no tiene tareas, inicializarlo
		if(backlogInstance.tasks.size() == 0){
			//Llamar al metodo init donde se inicializan las tareas
			redirect(action: "init", id: backlogInstance.id)
		}*/
		
		redirect(action: "toDo", id: backlogInstance.id)
		
		[backlogInstance: backlogInstance]
	}
	
	def init(Long id){
		//Tareas de las cartas del Semat
		def backlogInstance = Backlog.get(id)
		//Tareas de requermientos
		def r1a = new Task( name: 'La necesidad de un nuevo sistema es clara', category:'R1').save()
		def r1b = new Task( name: 'Se identificaron los usuarios', category:'R1').save()
		def r1c = new Task( name: 'posibles financiadores identificados', category:'R1').save()
		def r2 = new Task( name: 'Se acordaron el proposito', category:'R2').save()
		def r3 = new Task( name: 'Requerimientos Coherentes', category:'R3').save()
		def r4 = new Task( name: 'Requerimientos Acpetables', category:'R4').save()
		def r5 = new Task( name: 'Requerimientos enlazados', category:'R5').save()
		def r6 = new Task( name: 'Requerimientos Completados', category:'R6').save()
		
		//Agregar tareas al backlog
		//Requerimientos * concevidos
		backlogInstance.tasks.add(r1a)
		backlogInstance.tasks.add(r1b)
		backlogInstance.tasks.add(r1c)
		//
		backlogInstance.tasks.add(r2)
		backlogInstance.tasks.add(r3)
		backlogInstance.tasks.add(r4)
		backlogInstance.tasks.add(r5)
		backlogInstance.tasks.add(r6)
		//Oportunidades
		backlogInstance.tasks.add(new Task( name: 'Identificar Oportunidades', category:'O1').save())
		backlogInstance.tasks.add(new Task( name: 'hallar un invilucrado que desee invertir', category:'O1').save())
		backlogInstance.tasks.add(new Task( name: 'confirmar la necesidad de un producto', category:'O2').save())
		backlogInstance.tasks.add(new Task( name: 'identificar a los involucrados', category:'O2').save())
		backlogInstance.tasks.add(new Task( name: 'Hallar causas y consecuencias del problema', category:'O2').save())
		backlogInstance.tasks.add(new Task( name: 'Proponer por lo menos un producto como solucion', category:'O2').save())
		backlogInstance.tasks.add(new Task( name: 'Establecer el valor de la solucion', category:'O3').save())
		backlogInstance.tasks.add(new Task( name: 'presentar el impacto de la solucion a los involucrados', category:'O3').save())
		backlogInstance.tasks.add(new Task( name: 'Comunicar las ventajas del producto a los involucrados', category:'O3').save())
		backlogInstance.tasks.add(new Task( name: 'Seleccionar un producto', category:'O4').save())
		backlogInstance.tasks.add(new Task( name: 'Establecer las condiciones bajo las cuales el producto satisface las necesidades ', category:'O4').save())
		backlogInstance.tasks.add(new Task( name: 'Planificar el manejo del riesgo', category:'O4').save())
		backlogInstance.tasks.add(new Task( name: 'Producir una solucion que pueda abarcar la oportunidad', category:'O5').save())
		backlogInstance.tasks.add(new Task( name: 'Poner a disposicion el sistema', category:'O5').save())
		backlogInstance.tasks.add(new Task( name: 'lograr la aceptacion del sistema por parte de los involucrados', category:'O5').save())
		backlogInstance.tasks.add(new Task( name: 'Evidenciar beneficios del producto', category:'O6').save())
		backlogInstance.tasks.add(new Task( name: 'Confirmar que los beneficios son por lo menos tan buenos como lo esperado', category:'O6').save())
		//involucrados
		backlogInstance.tasks.add(new Task( name: 'Identificar a los involucrados', category:'I1').save())
		backlogInstance.tasks.add(new Task( name: 'Represtar a los involucrados', category:'I1').save())
		backlogInstance.tasks.add(new Task( name: 'Definir responsabilidades de los involucrados', category:'I1').save())
		backlogInstance.tasks.add(new Task( name: 'Reunirse con los involucrados', category:'I2').save())
		backlogInstance.tasks.add(new Task( name: 'acordar responsabilidades a los invilucrados', category:'I2').save())
		backlogInstance.tasks.add(new Task( name: 'Acordar colaboracion con los involucrados', category:'I2').save())
		backlogInstance.tasks.add(new Task( name: 'Gestionar responsabilidades a los involucrados ', category:'I3').save())
		backlogInstance.tasks.add(new Task( name: 'Brindar participacion en las desiciones a los involucrados', category:'I3').save())
		backlogInstance.tasks.add(new Task( name: 'Crear caminos de comunicacion con los involucrados', category:'I3').save())
		backlogInstance.tasks.add(new Task( name: 'Llegar a acuerdos con los involucrados con la forma como se toman las desiciones', category:'I4').save())
		backlogInstance.tasks.add(new Task( name: 'gestionar la espectativa de los involucrados ', category:'I4').save())
		backlogInstance.tasks.add(new Task( name: 'Pedir retroalimentacion de los involucrados', category:'I5').save())
		backlogInstance.tasks.add(new Task( name: 'Confirmar lanzamiento con los involucrados', category:'I5').save())
		backlogInstance.tasks.add(new Task( name: 'Cumplir y/o exceder las espectativas de los involucrados', category:'I1').save())
		
		backlogInstance.tasks.add(new Task( name: 'Identificar a los involucrados', category:'I1').save())
		backlogInstance.tasks.add(new Task( name: 'Identificar a los involucrados', category:'I1').save())
		/*backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()
		backlogInstance.tasks.add()*/
		
		redirect(controller: "Kernel",action: "show", id: backlogInstance.id)
	}


	def toDo(long id){

		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}
		
		if(backlogInstance.tasks.size() == 0) {
			redirect(action: "init", id: backlogInstance.id)
		}	

		[backlogInstance: backlogInstance]
	}

	def toDoing(){
		def backlogInstance = Backlog.get(session.sesion.id)
		backlogInstance.tasks.each{
			if(params."${it.name}" != null){
				println " ${it.name} " + params."${it.name}"
				def task = Task.get(it.id)
				if(task.state < 2)
					task.state = 1
				println "_>>${it.state} "
			}
		}
		redirect(action: "toDo", id:session.sesion.id)
	}
	def toDone(){
		def backlogInstance = Backlog.get(session.sesion.id)
		backlogInstance.tasks.each{
			if(params."${it.name}" != null){
				//println " ${it.name} " + params."${it.name}"
				def task = Task.get(it.id)
				if(task.state < 2)
					task.state = 2
				//println "_>>${it.state} "
			}
		}
		redirect(action: "Doing", id:session.sesion.id)
	}

	def Doing(long id){
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance: backlogInstance]
	}


	def Done(long id){
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance: backlogInstance]
	}




	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[backlogInstanceList: Backlog.list(params), backlogInstanceTotal: Backlog.count()]
	}

	def create() {
		[backlogInstance: new Backlog(params)]
	}

	def save() {
		def backlogInstance = new Backlog(params)
		if (!backlogInstance.save(flush: true)) {
			render(view: "create", model: [backlogInstance: backlogInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'backlog.label', default: 'Backlog'),
			backlogInstance.id
		])

		redirect(action: "show", id: backlogInstance.id)
	}

	def show(Long id) {
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance: backlogInstance]
	}

	def edit(Long id) {
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}

		[backlogInstance: backlogInstance]
	}

	def update(Long id, Long version) {
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (backlogInstance.version > version) {
				backlogInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'backlog.label', default: 'Backlog')] as Object[],
						"Another user has updated this Backlog while you were editing")
				render(view: "edit", model: [backlogInstance: backlogInstance])
				return
			}
		}

		backlogInstance.properties = params

		if (!backlogInstance.save(flush: true)) {
			render(view: "edit", model: [backlogInstance: backlogInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'backlog.label', default: 'Backlog'),
			backlogInstance.id
		])
		redirect(action: "show", id: backlogInstance.id)
	}

	def delete(Long id) {
		def backlogInstance = Backlog.get(id)
		if (!backlogInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "Done")
			return
		}

		try {
			backlogInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "Todo")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'backlog.label', default: 'Backlog'),
				id
			])
			redirect(action: "Doing", id: id)
		}
	}
}
