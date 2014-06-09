package sematproject

import org.springframework.dao.DataIntegrityViolationException

class ChangesBookController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [changesBookInstanceList: ChangesBook.list(params), changesBookInstanceTotal: ChangesBook.count()]
    }

    def create() {
        [changesBookInstance: new ChangesBook(params)]
    }

    def save() {
        def changesBookInstance = new ChangesBook(params)
        if (!changesBookInstance.save(flush: true)) {
            render(view: "create", model: [changesBookInstance: changesBookInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), changesBookInstance.id])
        redirect(action: "show", id: changesBookInstance.id)
    }

    def show(Long id) {
        def changesBookInstance = ChangesBook.get(id)
        if (!changesBookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "list")
            return
        }

        [changesBookInstance: changesBookInstance]
    }

    def edit(Long id) {
        def changesBookInstance = ChangesBook.get(id)
        if (!changesBookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "list")
            return
        }

        [changesBookInstance: changesBookInstance]
    }

    def update(Long id, Long version) {
        def changesBookInstance = ChangesBook.get(id)
        if (!changesBookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (changesBookInstance.version > version) {
                changesBookInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'changesBook.label', default: 'ChangesBook')] as Object[],
                          "Another user has updated this ChangesBook while you were editing")
                render(view: "edit", model: [changesBookInstance: changesBookInstance])
                return
            }
        }

        changesBookInstance.properties = params

        if (!changesBookInstance.save(flush: true)) {
            render(view: "edit", model: [changesBookInstance: changesBookInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), changesBookInstance.id])
        redirect(action: "show", id: changesBookInstance.id)
    }

    def delete(Long id) {
        def changesBookInstance = ChangesBook.get(id)
        if (!changesBookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "list")
            return
        }

        try {
            changesBookInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'changesBook.label', default: 'ChangesBook'), id])
            redirect(action: "show", id: id)
        }
    }
}
