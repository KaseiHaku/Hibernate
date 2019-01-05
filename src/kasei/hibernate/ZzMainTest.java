package kasei.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ZzMainTest {
	
	public static void main(String[] args) {
		
		HelloWorld h = new HelloWorld();
		h.setId(1);
		h.setMsg("main: hello hibernate");
			
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(h);
		session.getTransaction().commit();;
		session.close();
		sessionFactory.close();
	}
}
