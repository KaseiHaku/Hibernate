package h25ContainerMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class H25Group {
	private int id;
	private String name;
	
/*	private List<H25User> users = new ArrayList<H25User>(); //取出的数据需要排序用List
	@OneToMany(mappedBy="group",
			cascade={CascadeType.ALL},
			fetch=FetchType.EAGER
		)
	@OrderBy("id ASC, name DESC")//按id升序，那么降序排序
	public List<H25User> getUsers() {
		return users;
	}
	public void setUsers(List<H25User> users) {
		this.users = users;
	}*/
	
	private Map<Integer, H25User> users = new HashMap<Integer, H25User>();	
	@OneToMany(mappedBy="group",
			cascade={CascadeType.ALL},
			fetch=FetchType.EAGER
		)
	@MapKey(name="id")//用 id 列作为 Map 的 key
	public Map<Integer, H25User> getUsers() {
		return users;
	}
	public void setUsers(Map<Integer, H25User> users) {
		this.users = users;
	}
	@Id
	@GeneratedValue
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
	
	
}
