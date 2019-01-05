package kasei.hibernate.a01xml.b02relationMap.c03Single121pk;

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
	public void testOne2One() {
		
	}	
}
