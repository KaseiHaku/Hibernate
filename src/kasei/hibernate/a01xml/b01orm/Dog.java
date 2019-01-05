package kasei.hibernate.a01xml.b01orm;

import java.util.Date;

public class Dog {
	
	private Integer id;						// 数字
	private String name;					// 字符串
	private Date birthday;					// 日期
	private Color color;					// enum
	private DogProperties dogProperties;	// 组件
	private String anonymous;				// 该属性不做映射处理
	
	public Integer getId() {
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public DogProperties getDogProperties() {
		return dogProperties;
	}
	public void setDogProperties(DogProperties dogProperties) {
		this.dogProperties = dogProperties;
	}

	public String getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
}
