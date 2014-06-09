package sematproject

import org.springframework.dao.DataIntegrityViolationException

class UserController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def hoome(Long id) {
		def userInstance = User.get(id)
		if(session.user == null)
			redirect( action:'login')
		[userInstance: userInstance]
	}

	def login() {
	}

	def hlogin() {
		def user = User.findByName(params.name)
		if (!user || user.password != params.password ) {
			flash.message = " "
			redirect( action:'login')
			return
		} else {
			session.user = user
			redirect(action:'hoome', id:session.user.id)
		}
	}

	def logout() {
		if(session.user) {
			session.user = null
			redirect(action:'login')
		}
	}
	
	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[userInstanceList: User.list(params), userInstanceTotal: User.count()]
	}

	def create() {
		[userInstance: new User(params)]
	}

	def save() {
		try {
			sendMail {
				to "${params.email}"
				subject "Bienvenido ${params.realname} a Semat "
				html '<table border="0" witdh="100%"> \n\
                                      <TR bgcolor="green">\n\
                                      <center><H1><font color="white"><I><B>SEMAT</B></I></font></H1> <HR WIDTH=800 ></center>\n\
                                      </TR>\n\
                                      <tR>\n\
                                      <H3><font color="BLACK">Bienvenido a semat, gracias por usar esta aplicacion</FONT> </H3>\n\
                                      <H3><font color="BLACK">En esta aplicacion usted encontrara una ayuda para el desarrollo de su proyecto de software</font></H3> \n\
                                      <H3><font color="BLACK">Dirijase a la pagina principal de </FONT><A HREF="http://www.GOOGLE.com/"> Semat</A></H3>\n\
                                      </tR>\n\
                                      <TR>\n\
                                      <hr width=800><center><h5><font color="BLACK">Projecto semat</font></h5></center>\n\
                                      </TR>\n\
                                      </Table>'
			}
                        
			def userInstance = new User(params)
			if (!userInstance.save(flush: true)) {
				flash.message = "Usuario ya esta registrado"
				redirect( action:'create')
				return
			}
                        redirect( action:'login')   
                        
		} catch (Exception e) {
                         flash.message = "Usuario ya esta registrado"
				redirect( action:'create')
            }
	}

	def show(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}

	def edit(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}

	def update(Long id, Long version) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (userInstance.version > version) {
				userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'user.label', default: 'User')] as Object[],
						"Another user has updated this User while you were editing")
				render(view: "edit", model: [userInstance: userInstance])
				return
			}
		}

		userInstance.properties = params

		if (!userInstance.save(flush: true)) {
			render(view: "edit", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'user.label', default: 'User'),
			userInstance.id
		])
		redirect(action: "show", id: userInstance.id)
	}

	def delete(Long id) {
		def userInstance = User.get(id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "show", id: id)
		}
	}

	def restore () {
	}

	def hrestore () {

		def userInstance = User.findByEmail(params.email)
		println userInstance
		if( userInstance ) {
			sendMail {
				to "${params.email}"
				subject "Semat - Restablecer contrase�a"
				body 'Tu contraseña es ${userInstance.password}'
			}

			redirect( action:'login')
		}else{

			flash.message = " "
			redirect (action: "restore")
		}
	}
}
