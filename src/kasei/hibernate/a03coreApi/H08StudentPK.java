package kasei.hibernate.a03coreApi;

public class H08StudentPK implements java.io.Serializable{
	
	private int id;
	private String name;
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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof H08StudentPK){
			H08StudentPK pk = (H08StudentPK) o;
			if(this.id == pk.getId() && this.name == pk.getName()){
				return true;
			}
		}
		return false;
	}
	
	@Override//必须override hashCode：因为要放入hash表
	public int hashCode(){
		return this.name.hashCode();
	}
}
