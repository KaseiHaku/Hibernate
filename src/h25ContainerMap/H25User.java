package h25ContainerMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class H25User {
	private int id;
	private String name;
	private H25Group group;//多对一时，在多的一方加冗余 
	
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
	
	@ManyToOne(cascade={CascadeType.ALL})//在关联关系中自动保存关联对象
	@JoinColumn(name="groupXX")//有mappedBy不能用这个注释,这个外键自动加载多的一方
	public H25Group getGroup() {
		return group;
	}
	public void setGroup(H25Group group) {
		this.group = group;
	}
}
