package kasei.hibernate.a02anno.b02relationMap.c01single121fk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="a02b02c01_wife")
public class Wife {
	private Integer id;
	private String name;
	
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
}
