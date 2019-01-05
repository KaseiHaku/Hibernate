package h26TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {		

	public static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass(){
		Configuration cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
	
	@Test		
	public void testSave() {
		H26Orgnization o1 = new H26Orgnization();
		o1.setName("总公司");
		H26Orgnization o2 = new H26Orgnization();
		o2.setName("分公司1");
		H26Orgnization o3 = new H26Orgnization();
		o3.setName("分公司2");
		H26Orgnization o4 = new H26Orgnization();
		o4.setName("分公司1->部门1");
		H26Orgnization o5 = new H26Orgnization();
		o5.setName("分公司1->部门2");
		
		o1.getChilds().add(o2);
		o1.getChilds().add(o3);
		o2.getChilds().add(o4);
		o2.getChilds().add(o5);
		o2.setParent(o1);
		o3.setParent(o1);
		o5.setParent(o2);
		o4.setParent(o2);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(o1);
		session.getTransaction().commit();
	}
	
	@Test		
	public void testGet() {
		testSave();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H26Orgnization o1 = session.load(H26Orgnization.class, 1);
		print(o1, 0);
		session.getTransaction().commit();
	}
	
	private void print(H26Orgnization o, int indent){
		String str = "";
		for(int i=0; i<indent; i++){
			str += "----";
		}
		System.out.println(str + o.getName());
		for(H26Orgnization child:o.getChilds()){
			print(child, indent+1);
		}
	}
}
