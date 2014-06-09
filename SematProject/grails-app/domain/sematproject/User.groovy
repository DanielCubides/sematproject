package sematproject
 
import java.util.ArrayList 

class User implements Serializable {

	String name
	String realname
	String password
	String email
	
	User(String name,String realname, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.realname = realname;
	}
	
	//Define atributes
	
	
	
	//GROM relationship
	static hasMany = [rus:RelUserSesion]
	//GROM constraints
    static constraints = {
		name(blank:false, unique:true)
		realname(blank:false)
		password(blank:false,size: 5..15, password:true)
		email(blank:false, email: true, unique:true)
    }
	


}
