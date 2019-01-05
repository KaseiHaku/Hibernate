package h24Many2ManyCDUS;


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
	
	//关联关系的增删改查，多对多
	@Test		
	public void testSaveStudent() {
		H24Student s = new H24Student();
		s.setName("qwer");
		H24Teacher t = new H24Teacher();
		t.setName("fffggg");
		t.getStudents().add(s);
		//s.getTeachers().add(t);
		
		H24Student s2 = new H24Student();
		s2.setName("asdf");
		H24Teacher t2 = new H24Teacher();
		t2.setName("hhhyyy");
		//t2.getStudents().add(s2);
		s2.getTeachers().add(t2);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(t);//这操作不插入中间表数据，有待研究
		session.save(s2);
		session.getTransaction().commit();
	}
	
}
