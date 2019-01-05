package kasei.hibernate.a02anno.b01orm;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DogProperties {
	private Integer age;
	private Color color;

	@Enumerated(EnumType.STRING)
	@Column(name = "prop_color", nullable = true)
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Column(nullable = true)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
