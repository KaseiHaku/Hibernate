package h21Many2One_One2ManyBidirectional;

import java.util.Set;

public class H21Group {
	private int id;
	private String name;
	private Set<H21User> userSet; 

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
	
	public Set<H21User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<H21User> userSet) {
		this.userSet = userSet;
	}
}
