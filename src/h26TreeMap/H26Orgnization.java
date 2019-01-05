package h26TreeMap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class H26Orgnization {
	private int id;
	private String name;
	private H26Orgnization parent;
	private Set<H26Orgnization> childs = new HashSet<H26Orgnization>();
	
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
	@ManyToOne
	@JoinColumn(name="parentId")
	public H26Orgnization getParent() {
		return parent;
	}
	public void setParent(H26Orgnization parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<H26Orgnization> getChilds() {
		return childs;
	}
	public void setChilds(Set<H26Orgnization> childs) {
		this.childs = childs;
	}	
}
