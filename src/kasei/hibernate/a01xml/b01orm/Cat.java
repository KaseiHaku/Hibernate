package kasei.hibernate.a01xml.b01orm;


public class Cat {
	
	private CatPk pk;
	private Integer age;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public CatPk getPk() {
		return pk;
	}
	public void setPk(CatPk pk) {
		this.pk = pk;
	}	
}
