package h31HibernateCache;


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
	public void testSave(){
		H31Student s = new H31Student();
		H31Student s2 = new H31Student();
		H31Student s3 = new H31Student();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.save(s2);
		session.save(s3);
		session.getTransaction().commit();
	}
	
	@Test		
	public void testFirstLevelCache() {
		//一级缓存:session级别的缓存
		testSave();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H31Student s = session.load(H31Student.class, 1);
		System.out.println(s.getId());//发送sql语句
		
		//同一个 session 中 load
		H31Student s2 = session.load(H31Student.class, 1);
		System.out.println(s2.getId());//不发送sql语句，直接从内存中取
		session.getTransaction().commit();
	}
	
	@Test		
	public void testSecondLevelCache() {
		//二级缓存:sessionFactory级别的缓存，可以跨session存在
		//二级缓存适合存放的数据：1、经常被访问；2、不会经常被改动；3、数量有限
		/* load 默认使用二级缓存
		 * iterate 默认使用二级缓存
		 * list 默认往二级缓存中放数据，但是查询不会从二级缓存取数据
		 * */
		testSave();
		Session session = sf.openSession();
		session.beginTransaction();
		H31Student s = session.load(H31Student.class, 1);
		System.out.println(s.getId());//发送sql语句
		session.getTransaction().commit();
		session.close();
		
		//在不同 session 中 load
		Session session2 = sf.openSession();
		session2.beginTransaction();
		H31Student s2 = session2.load(H31Student.class, 1);
		System.out.println(s2.getId());//会再发一条sql语句，配置二级缓存后则不会发
		session2.getTransaction().commit();
		session2.close();			
	}	
}
