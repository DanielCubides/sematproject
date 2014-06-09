package sematproject

import java.io.Serializable;
 
class RelUserSesion implements Serializable {

	Session sesion
	User user
	boolean member
	
    public RelUserSesion(Session sesion, User user, boolean member) {
		super();
		this.sesion = sesion;
		this.user = user;
		this.member = member
	}

	static constraints = {
    }
}
