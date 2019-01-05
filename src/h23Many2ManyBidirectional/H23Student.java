package h23Many2ManyBidirectional;

import java.util.Set;

public class H23Student {
	private int id;
	private String name;
	private Set<H23Teacher> teachers;
	
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
	
	public Set<H23Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<H23Teacher> teachers) {
		this.teachers = teachers;
	}	
}
