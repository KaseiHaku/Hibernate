package kasei.hibernate.a02anno.b02relationMap.c05compositeId121;

import java.io.Serializable;


public class WifePk  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override // 必须override equals：因为要比较两个实例是不是同一个
	public boolean equals(Object obj){
		if(obj instanceof WifePk){
			WifePk pk = (WifePk) obj;
			if(this.id == pk.getId() && this.age == pk.getAge()){
				return true;
			}
		}
		return false;
	}
	
	@Override// 必须override hashCode：因为要放入hash表
	public int hashCode(){
		return this.id.hashCode();
	}
}
