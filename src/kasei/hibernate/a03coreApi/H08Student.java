package kasei.hibernate.a03coreApi;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
class H08Student { 
	
	private H08StudentPK pk;
	private int age;
	

	@EmbeddedId
	public H08StudentPK getPk() {
		return pk;
	}
	public void setPk(H08StudentPK pk) {
		this.pk = pk;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
