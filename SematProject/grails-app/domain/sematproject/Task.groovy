package sematproject
 
import java.io.Serializable;
import java.util.Date;

class Task implements Serializable {
	String name
	String description = " "
	String category
	Date startedDate = new Date()
	Date FinishDate = startedDate + 20
	int state = 0
	
	public Task(String name, char category) {
		super();
		this.name = name;
		this.category = category;
		
	}
	static belongsTo = Backlog

    static constraints = {
		startedDate(nullable:true)
    }
}
