package kasei.hibernate.a02anno.b02relationMap.c09M2N;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import kasei.hibernate.a02anno.b02relationMap.c08N21and12N.User;

@Entity
@Table(name = "a02b02c09_student")
public class Student {
	private Integer id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(mappedBy="students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
