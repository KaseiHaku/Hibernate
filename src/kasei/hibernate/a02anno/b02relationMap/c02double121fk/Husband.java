package kasei.hibernate.a02anno.b02relationMap.c02double121fk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c02_husband")
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

	@OneToOne(mappedBy="husband") // 表示在 Wife 这个实体类中的 husband 属性（其实是get方法后面的字符串）上已经建了外键了，这里不用再建外键
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
