package kasei.hibernate.a01xml.b02relationMap.c03Single121pk;

public class Husband {
	private int id;
	private String name;
	private Wife wife;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}	
}
