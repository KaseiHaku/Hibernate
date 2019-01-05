package kasei.hibernate.a02anno.b02relationMap.c02double121fk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c02_wife")
public class Wife {
	
	private Integer id;
	private String name;
	private Husband husband;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@OneToOne
	public Husband getHusband() {
		return husband;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}
