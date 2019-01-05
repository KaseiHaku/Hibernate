package h20One2ManyUnidirectional;

import java.util.Set;



public class H20Group {
	private int id;
	private String name;
	private Set<H20User> userSet; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<H20User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<H20User> userSet) {
		this.userSet = userSet;
	}
}
