package sematproject

import org.springframework.dao.DataIntegrityViolationException

class KernelController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "looby", params: params)
    }
	
	def looby(long id){
		def kernelInstance = Kernel.get(id)
		if (!kernelInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
			redirect(action: "list")
			return
		}
		[kernelInstance: kernelInstance]
		
	}

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [kernelInstanceList: Kernel.list(params), kernelInstanceTotal: Kernel.count()]
    }

    def create() {
        [kernelInstance: new Kernel(params)]
    }

    def save() {
        def kernelInstance = new Kernel(params)
        if (!kernelInstance.save(flush: true)) {
            render(view: "create", model: [kernelInstance: kernelInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'kernel.label', default: 'Kernel'), kernelInstance.id])
        redirect(action: "show", id: kernelInstance.id)
    }

    def show(Long id) {
        def kernelInstance = Kernel.get(id)
        if (!kernelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "list")
            return
        }
		session.sesion = Session.get(id)
        [kernelInstance: kernelInstance]
    }

    def edit(Long id) {
        def kernelInstance = Kernel.get(id)
        if (!kernelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "list")
            return
        }

        [kernelInstance: kernelInstance]
    }

    def update(Long id, Long version) {
        def kernelInstance = Kernel.get(id)
        if (!kernelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (kernelInstance.version > version) {
                kernelInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'kernel.label', default: 'Kernel')] as Object[],
                          "Another user has updated this Kernel while you were editing")
                render(view: "edit", model: [kernelInstance: kernelInstance])
                return
            }
        }

        kernelInstance.properties = params

        if (!kernelInstance.save(flush: true)) {
            render(view: "edit", model: [kernelInstance: kernelInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'kernel.label', default: 'Kernel'), kernelInstance.id])
        redirect(action: "show", id: kernelInstance.id)
    }

    def delete(Long id) {
        def kernelInstance = Kernel.get(id)
        if (!kernelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "list")
            return
        }

        try {
            kernelInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'kernel.label', default: 'Kernel'), id])
            redirect(action: "show", id: id)
        }
    }
}
