package h28InheritMap.tabPerClass;

import javax.persistence.Entity;

@Entity
public class H28Teacher extends H28Person{
	private String scale;
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
}
