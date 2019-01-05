package kasei.hibernate.a05hibernateQL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class NativeQueryDemo {

	private Session session = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory().getCurrentSession();
	
	// 获取所有的Order对象，得到一个List集合
	public void list(){
	    String sql = "select * from user";
	    NativeQuery<Obj> nativeQuery = session.createNativeQuery(sql, Obj.class);
	    List<Obj> list = nativeQuery.getResultList();
	    for(Obj o : list){
	    	
	    }
	}
	
	// 分页
	public void pageList() {
		String sql = "select * from orders";
	    //setFirstResult(1)从1开始
		Query<Obj> query = session.createNativeQuery(sql, Obj.class).setFirstResult(1).setMaxResults(4);
	    List<Obj> list = query.getResultList();
	    for(Obj o : list){	         
	    }
	}
	
	// 占位符
	public void placeholder() {
		
		String sql ="select * from table where id= ? and name= :kasei ";
		int id = 8;
		String kasei = "kasei";
		session.beginTransaction();
		NativeQuery<Obj> nativeQuery = session.createNativeQuery(sql, Obj.class);
		nativeQuery.setParameter(1, 8).setParameter("kasei", kasei);	// 从第一个参数开始计
		
		List<Obj> resultList  = nativeQuery.getResultList();
		// int i = nativeQuery.executeUpdate();// 用于执行非查询语句
		for(Obj user:resultList) {
			//获取处理结果
		}
	}

	
	// delete
	public void delete(){
	    String sql = "delete from orders where id in (:idList)"; 
	    session.beginTransaction();
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    Query<?> query = session.createNativeQuery(sql).setParameter("idList", list);
	    int i = query.executeUpdate();
	    System.out.println(i);
	    session.getTransaction().commit();
	}
	
	// 获取单列
	public void singleValue(){
	    String sql = "select order_id from orders";
	    Query<String> query = session.createNativeQuery(sql);
	    List<String> list = query.getResultList();
	    for(String str : list){
	        System.out.println(str);
	    }
	}
	
	// 获取多列
	public void getObjectArray(){
	    String sql = "select c.name, c.phone_number, o.order_id, o.create_time from orders o join customer c on o.customer_id = c.id";
	    Query<Object[]> query = session.createNativeQuery(sql);
	    List<Object[]> list = query.getResultList();
	    for(Object[] o : list){
	         System.out.println(o[0] + ";;" + o[1] + ";;" + o[2]);
	    }
	}
}
