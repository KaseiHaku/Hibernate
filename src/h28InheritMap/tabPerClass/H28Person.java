package h28InheritMap.tabPerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//设置继承映射模式
@TableGenerator(
		name="genName1",
		table="h28GenTab",
		pkColumnName="pk_key",
		valueColumnName="pk_value",
		pkColumnValue="Person",
		initialValue=1,
		allocationSize=1
	)
public class H28Person {
	private int id;
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="genName1")
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
