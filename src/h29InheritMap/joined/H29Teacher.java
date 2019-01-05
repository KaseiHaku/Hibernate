package h29InheritMap.joined;

import javax.persistence.Entity;

@Entity
public class H29Teacher extends H29Person{
	private String scale;
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
}
