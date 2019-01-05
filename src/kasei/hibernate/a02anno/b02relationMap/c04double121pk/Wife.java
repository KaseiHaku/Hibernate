package kasei.hibernate.a02anno.b02relationMap.c04double121pk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c04_wife")
public class Wife {
	private Integer id;
	private String name;
	private Husband husband;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
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
