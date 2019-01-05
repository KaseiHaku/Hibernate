package h27InheritMap.singleTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//设置继承映射模式
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)
//设置用于区分是哪个类的字段，字段名=discriminator
@DiscriminatorValue("person")//表示Person存入表的时候，用什么表示存入的是Person类
public class H27Person {
	
	private int id;
	private String name;
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
}
