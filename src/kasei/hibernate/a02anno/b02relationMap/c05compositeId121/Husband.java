package kasei.hibernate.a02anno.b02relationMap.c05compositeId121;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c05_husband")
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
	@JoinColumns(value= {
			@JoinColumn(name="wifeid",referencedColumnName="id"),
			@JoinColumn(name="wifeage",referencedColumnName="age")})
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
