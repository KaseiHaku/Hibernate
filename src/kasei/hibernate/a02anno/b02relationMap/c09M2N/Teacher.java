package kasei.hibernate.a02anno.b02relationMap.c09M2N;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import kasei.hibernate.a02anno.b02relationMap.c08N21and12N.User;

@Entity
@Table(name = "a02b02c09_teacher")
public class Teacher {
	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
	
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
	@ManyToMany
	@JoinTable(name="a02b02c09_s_t",
		joinColumns={@JoinColumn(name="teacher_id")},//设置本表对应的字段
		inverseJoinColumns={@JoinColumn(name="student_id")}//设置联接表对应的字段
	)//改变生成的中间表的属性
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
