package kasei.hibernate.a02anno.b02relationMap.c08N21and12N;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c08_group")
public class Group {

	private Integer id;
	private String name;
	private Set<User> users = new HashSet<User>();
	
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
	
	@OneToMany(mappedBy="group",
			cascade={CascadeType.ALL},//设置级联关系：all表示所有操作都进行级联操作
			fetch=FetchType.EAGER//表示取group的时候立马把所有的user全取出来
			)// 这种不管你写在那边都会在多的一方加外键，不会在少的一方加
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
			
}
