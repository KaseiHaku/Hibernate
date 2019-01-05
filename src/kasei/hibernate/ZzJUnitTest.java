package kasei.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ZzJUnitTest {		
	
	public static Configuration cfg = null;
	public static SessionFactory sf = null;
	public static Session s = null;
	
	@BeforeClass
	public static void beforeClass(){
		cfg = new Configuration();
		sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		s = sf.getCurrentSession();
		// s = sf.openSession();  // 采用这种方式，结束后需要 session.close();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
	
	@Test		
	public void testHelloWorld() {
		
		HelloWorld h = new HelloWorld();
		h.setId(2);
		h.setMsg("junit: hello hibernate");
		
		s.beginTransaction();
		s.save(h);
		s.getTransaction().commit();
	}	
}
