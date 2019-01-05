package kasei.hibernate.a02anno.b01orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="a02b01_Cat")
public class Cat {

	private CatPk pk;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Id//联合主键，注解方法1
	//@EmbeddedId//联合主键，注解方法2
	public CatPk getPk() {
		return pk;
	}

	public void setPk(CatPk pk) {
		this.pk = pk;
	}
}
