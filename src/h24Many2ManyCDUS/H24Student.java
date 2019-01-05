package h24Many2ManyCDUS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class H24Student {
	private int id;
	private String name;
	private Set<H24Teacher> teachers = new HashSet<H24Teacher>();
	
	@Id
	@GeneratedValue
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
	
	@ManyToMany(
			cascade={CascadeType.ALL},//设置级联关系：all表示所有操作都进行级联操作
			fetch=FetchType.EAGER//表示取group的时候立马把所有的user全取出来
			)
	@JoinTable(name="h24T_S",
		joinColumns={@JoinColumn(name="student_id")},//设置本表对应的字段
		inverseJoinColumns={@JoinColumn(name="teacher_id")}//设置联接表对应的字段
	)
	public Set<H24Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<H24Teacher> teachers) {
		this.teachers = teachers;
	}	
}
