package sematproject

import java.io.Serializable;
 
class Kernel implements Serializable {
	float progress
	ArrayList cards = new ArrayList()
	
	Kernel(){
	this.progress = 0.0;
	this.cards = []	
	}
	
	//GROM Relationship
	static belongsTo = Session

    static constraints = {
    }
}
