package h19Many2OneUnidirectional;

public class H19User {
	private int id;
	private String name;
	private H19Group group;//多对一时，在多的一方加冗余 

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

	public H19Group getGroup() {
		return group;
	}
	public void setGroup(H19Group group) {
		this.group = group;
	}
}
