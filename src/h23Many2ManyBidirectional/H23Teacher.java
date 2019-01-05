package h23Many2ManyBidirectional;

import java.util.Set;


public class H23Teacher {
	private int id;
	private String name;
	private Set<H23Student> students; 
	

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

	public Set<H23Student> getStudents() {
		return students;
	}
	public void setStudents(Set<H23Student> students) {
		this.students = students;
	}
}
