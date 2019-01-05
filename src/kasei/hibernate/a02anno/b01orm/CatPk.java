package kasei.hibernate.a02anno.b01orm;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable//联合主键，注解方法1
public class CatPk implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	@Override // 必须override equals：因为要比较两个实例是不是同一个
	public boolean equals(Object obj){
		if(obj instanceof CatPk){
			CatPk pk = (CatPk) obj;
			if(this.id == pk.getId() && this.name == pk.getName()){
				return true;
			}
		}
		return false;
	}
	
	@Override// 必须override hashCode：因为要放入hash表
	public int hashCode(){
		return this.name.hashCode();
	}
}
