package kasei.hibernate.a02anno.b02relationMap.c05compositeId121;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="a02b02c05_wife")
public class Wife {
	
	private WifePk pk;
	private String name;
	
	
	@EmbeddedId
	public WifePk getPk() {
		return pk;
	}
	public void setPk(WifePk pk) {
		this.pk = pk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
