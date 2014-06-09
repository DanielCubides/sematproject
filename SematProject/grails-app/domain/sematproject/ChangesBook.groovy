package sematproject

import java.io.Serializable;
 
class ChangesBook implements Serializable {
	ArrayList changes = new ArrayList()
	
	static belongsTo = Session
	
	public ChangesBook() {
		this.changes = []
	}
	
    static constraints = {
    }
}
