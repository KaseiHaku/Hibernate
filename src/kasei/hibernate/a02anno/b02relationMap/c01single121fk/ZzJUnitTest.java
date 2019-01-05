package kasei.hibernate.a02anno.b02relationMap.c01single121fk;

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
		sf = cfg.configure().buildSessionFactory();
		s = sf.getCurrentSession();
		// s = sf.openSession();  // 采用这种方式，结束后需要 session.close();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
	
	@Test		
	public void test() {
		// 直接 run as junit test，查看数据库中表的结构
	}	
}
