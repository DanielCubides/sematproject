import sematproject.*

class BootStrap {

    def init = { servletContext ->
		def u1 = new User( name: 'Daniel',realname:'Daniel Cubides', password:123456,email:'usuario1@semat.pj').save()
		def u2 = new User( name: 'Ana',realname:'Ana Torres', password:123456,email:'usuario2@semat.pj').save()
		def u3 = new User( name: 'Jimmy',realname:'Jimmy Cardenas', password:123456,email:'usuario3@semat.pj').save()
		def u4 = new User( name: 'Milena',realname:'Milena Castillo', password:123456,email:'usuario4@semat.pj').save()
		def u5 = new User( name: 'Alejandro',realname:'SUPER ALEJO', password:123456,email:'usuario5@semat.pj').save()
		def u6 = new User( name: 'Alexis',realname:'Alexis Sierra', password:123456,email:'usuario6@semat.pj').save()
		
		def s1 = new Session( name: 'A').save()
		def s2 = new Session( name: 'B').save()
		def s3 = new Session( name: 'C').save()
		
		new RelUserSesion(sesion:s1,user: u1,member: true).save()
		new RelUserSesion(sesion:s1, user:u2, member:false).save()
		new RelUserSesion(sesion:s1, user:u3, member:true).save()
		new RelUserSesion(sesion:s1, user:u5, member:true).save()
		new RelUserSesion(sesion:s2, user:u1, member:false).save()
		new RelUserSesion(sesion:s2, user:u2, member:true).save()
		new RelUserSesion(sesion:s3, user:u3, member:false).save()
    }
    def destroy = {
    }
}
