package kasei.hibernate.a02anno.b02relationMap.c03single121pk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c03_husband")
public class Husband {
	private Integer id;
	private String name;
	private Wife wife;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Wife getWife() {
		return wife;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
