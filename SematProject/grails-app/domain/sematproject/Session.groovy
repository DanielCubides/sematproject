package sematproject

import java.io.Serializable;

 

class Session implements Serializable {
	
	String name
	String description
	Backlog backlog =  new Backlog();
	Kernel kernel = new Kernel();
	ChangesBook changesbook= new ChangesBook();
	
	public Session( String name ) {
		this.name = name;
		this.changesbook 
		this.kernel 
		this.backlog 
		
	}
	
	
	//GROM Relationship
    static hasMany = [rus:RelUserSesion]
	
	//GROM constraints
    static constraints = {
		name(unique:true, nullable:false)
		description(nullable:true)
		kernel(nullable:true, display:false)
		backlog(nullable:true, display:false)
		changesbook(nullable:true , display:false )
		
    }
}
