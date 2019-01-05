package kasei.hibernate.a02anno.b01orm;

import java.util.Date;

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
	public void test() {
		Dog dog = new Dog();
		dog.setName("大黄");
		dog.setBirthday(new Date());
		dog.setColor(Color.YELLO);
		
		Cat cat = new Cat();
		cat.setAge(12);
		CatPk pk = new CatPk();
		pk.setId(2);
		pk.setName("喵");
		cat.setPk(pk);
		
		s.beginTransaction();
		s.save(dog);
		s.save(cat);
		s.getTransaction().commit();
	}	
}
