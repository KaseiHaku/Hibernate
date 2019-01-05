package kasei.hibernate.a02anno.b02relationMap.c01single121fk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "a02b02c01_husband")
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

	@OneToOne // 表示在当前实体类中插入一个外键列，列名默认为 wife_id
	@JoinColumn(name="wifeid") // 修改外键列列名 
	/* 用于联合主键的外键映射
	@JoinColumns(value= {
			@JoinColumn(name="aa",referencedColumnName="AA"),
			@JoinColumn(name="bb",referencedColumnName="BB")})
	*/
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
