package kasei.hibernate.a05hibernateQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class HqlQueryDemo {

	private Session session = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory().getCurrentSession();
	
	// 增 删 改
	public void update() {
		session.beginTransaction();
		String hql = "insert into Obj(name, desc, num)values('对象', '描述', 9)";
		Query<Obj> query = session.createQuery(hql, Obj.class);
		int result = query.executeUpdate();
		if(result>0) {
			System.out.println("更新失败");
		}
		session.getTransaction().commit();
	}
	
	// 查：
	public void select1() {
		session.beginTransaction();
		String hql = "select c.name, c.num from Obj c where c.num<10";		
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.getResultList();

		for(Object[] o: list){
			System.out.println("name="+o[0]);
			System.out.println("num="+o[1]);
		}
		session.getTransaction().commit();
	}
	
	
	// 查：
	public void select2() {
		session.beginTransaction();
		String hql = "from Obj c where c.name > 'c5' order by c.name desc";
		Query query = session.createQuery(hql, Obj.class);
		List<Obj> list = query.getResultList();

		for(Obj o: list){
			System.out.println(o.getName());
		}
		session.getTransaction().commit();
	}
	
	// 查：
	public void select3() {
		session.beginTransaction();
		// 把查询出来的结果构造成一个对象
		String hql = "select new h30QL.H30MsgInfo(m.id, m.cont, m.topic.title, m.topic.category.name) from H30Msg m";
		Query query = session.createQuery(hql);
		List<H30MsgInfo> list = query.getResultList();
		
		for(Object obj : query.list()){
			H30MsgInfo m =(H30MsgInfo)obj;
			System.out.println(m.getCont());
		}	
		session.getTransaction().commit();
	}
	
	// 查：
	public void select4() {
		session.beginTransaction();
		// 根据对象查询
		String hql = "from Obj m where m = :obj";
		Query query = session.createQuery(hql);
		Obj obj = new Obj();
		obj.setId(2);		
		query.setParameter("MsgToSearch", obj);
		obj = (Obj) query.getSingleResult();
		session.getTransaction().commit();
	}
}
