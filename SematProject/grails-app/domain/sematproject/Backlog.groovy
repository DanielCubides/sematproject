package sematproject

import java.util.Date;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.uaa.client.protobuf.UaaClient.Product;
 
class Backlog {
	String ProductOwner = "forChose";
	Date StartedDate = new Date()
	Date SpringDate
	Date HoursToSring
	List tasks = []
	
	public Backlog() {
		
	}
	
	public Backlog(String productOwner,  Date springDate) {
		super();
		ProductOwner = productOwner;
		SpringDate = springDate;
		HoursToSring = SpringDate - StartedDate;
	}
	
	static belongsTo = Session
	static hasMany = [tasks:Task]
	static mapping = { tasks lazy: false}
	
	
	static constraints = {
		productOwner(nullable:true)
		startedDate(nullable:true)
		springDate(nullable:true)
		hoursToSring(nullable:true , display:false )
	}

	
	
}
