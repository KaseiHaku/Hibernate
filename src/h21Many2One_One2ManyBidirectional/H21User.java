package h21Many2One_One2ManyBidirectional;


public class H21User {
	private int id;
	private String name;
	private H21Group group;//多对一时，在多的一方加冗余 

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

	public H21Group getGroup() {
		return group;
	}
	public void setGroup(H21Group group) {
		this.group = group;
	}
}
