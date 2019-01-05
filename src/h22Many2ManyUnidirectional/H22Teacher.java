package h22Many2ManyUnidirectional;

import java.util.Set;


public class H22Teacher {
	private int id;
	private String name;
	private Set<H22Student> students; 

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
	

	public Set<H22Student> getStudents() {
		return students;
	}
	public void setStudents(Set<H22Student> students) {
		this.students = students;
	}
}
