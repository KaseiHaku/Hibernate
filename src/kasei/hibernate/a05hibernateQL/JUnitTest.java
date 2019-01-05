package kasei.hibernate.a05hibernateQL;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
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
	public void testQuery() {	
				
	}


		
}
