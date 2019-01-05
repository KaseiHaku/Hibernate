package h27InheritMap.singleTable;

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
		H27Student s = new H27Student();
		s.setName("tty");
		s.setScore(86);
		H27Teacher t = new H27Teacher();
		t.setName("ewed");
		t.setScale("高级");
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.save(s);
		session.getTransaction().commit();
	}	
}
