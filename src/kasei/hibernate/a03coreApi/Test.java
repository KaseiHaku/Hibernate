package kasei.hibernate.a03coreApi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class Test {

	/** ORM 中类的三种状态
	 * transient：内存中的一个对象，没有主键，缓存(session)中没有
	 * presistent：内存中有，缓存(session)中有，数据库有，有主键
	 * detached：内存有，缓存(session)中没有，数据库有，有主键
	 * 
	 * hibernate session 中会有缓存
	 * */	
	public static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass(){
		//在这个 测试类执行之前执行的代码
		Configuration cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass(){
		//在这个测试类之后执行的代码
		sf.close();
	}
	
	@org.junit.Test
	public void testConfiguration() {
		
		/** Hibernate 只能根据主键来存取数据 */
		
		Configuration cfg2 = new Configuration();//自动调用 classpath(即src目录) 下面的 hibernate.cfg.xml 文件
		Configuration cfg3 = new Configuration().configure("hibernate.cfg.xml");//调用src目录下指定的 hibernate 配置文件		
	}
	
	@org.junit.Test
	public void testSessionFactory(){
		
		H08Student student = new H08Student();
		H08StudentPK pk = new H08StudentPK();
		pk.setId(7);
		pk.setName("Miku");
		student.setPk(pk);
		student.setAge(16);
		
		Session s = sf.getCurrentSession();//如果当前环境中有session则取这个session，否则新建,保持动作事务性	
		s.beginTransaction();
		s.save(student);//保存记录
		s.getTransaction().commit();
		//自动关闭
		
		/*
		Session s2 = sf.openSession();//永远会新建一个session，如果不关闭会新建无数个session
		s2.beginTransaction();
		s2.save(student);
		s2.getTransaction().commit();
		s2.close();
		*/
	}

	@org.junit.Test
	public void testDelete(){//删除记录：注意delete()方法只能根据主键进行删除
		H08Student student = new H08Student();
		H08StudentPK pk = new H08StudentPK();
		pk.setId(2);
		pk.setName("Miku");
		student.setPk(pk);
		student.setAge(16);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.delete(student);
		session2.getTransaction().commit();
	}
	
	
	@org.junit.Test
	public void testLoad(){//load方法是懒汉式，只有在调用数据的时候才会发sql语句
		
		/* 前提条件：
		 * 1、注释掉 hibernate.cfg.xml配置文件中 
		 * <property name="hbm2ddl.auto">create</property>属性行
		 * 2、数据库中必须有数据，可以先执行本类中 testSessionFactory() 方法
		 * */
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.load(H08Student.class, pk);//根据主键从数据库中取对应的数据
		
		session.getTransaction().commit();		
		System.out.println(student.getAge());//commit会关闭session 所以这条语句放commit之后会报错
	}
	
	@org.junit.Test
	public void testGet(){//get方法一执行就发出sql语句
		/* 前提条件：
		 * 1、注释掉 hibernate.cfg.xml配置文件中 
		 * <property name="hbm2ddl.auto">create</property>属性行
		 * 2、数据库中必须有数据，可以先执行本类中 testSessionFactory() 方法
		 * */
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
		
		//前提数据库中必须有数据
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.get(H08Student.class, pk);//从数据库取一条记录转化成指定类型的对象
		session.getTransaction().commit();		
		System.out.println(student.getAge());
	}
	
	@org.junit.Test
	public void testUpdate(){
		
		/* 前提条件：
		 * 1、注释掉 hibernate.cfg.xml配置文件中 
		 * <property name="hbm2ddl.auto">create</property>属性行
		 * 2、数据库中必须有数据，可以先执行本类中 testSessionFactory() 方法
		 * */
		H08StudentPK pk = new H08StudentPK();
		pk.setId(7);
		pk.setName("Miku");
				
		//前提数据库中必须有数据
		//测试点：detached 内存中有，缓存中没有，数据库有
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.get(H08Student.class, pk);//从数据库取一条记录转化成指定类型的对象
		session.getTransaction().commit();		
		System.out.println(student.getAge());
		
		student.setAge(11);
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.update(student);//更新一个数据库对象
		session2.getTransaction().commit();
	}
	
	@org.junit.Test
	public void testUpdate2(){
		//在同一个session里面更改对象的属性值，即presistent状态，在session commit的时候将自动更新到数据库
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
		
		//测试点：presistent
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.get(H08Student.class, pk);//从数据库取一条记录转化成指定类型的对象
		student.setAge(99);
		session.getTransaction().commit();		
		System.out.println(student.getAge());
	}
	
	@org.junit.Test
	public void testUpdate3(){	
		//前提：数据库中有对应的记录
		//测试点：只更新对象中改动的数据
		//dynamic-update="true"
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Teacher t = session.get(H08Teacher.class, 1);//从数据库取一条记录转化成指定类型的对象
		t.setName("wasd");//t对象 presistent 状态
		session.getTransaction().commit();		
		
		t.setName("fdf");//commit之后student detached 状态
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		session2.getTransaction().commit();		
	}
	
	@org.junit.Test
	public void testUpdate4(){
		
		//测试点：跨session 只更新数据变动 属性
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
			
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.get(H08Student.class, pk);//从数据库取一条记录转化成指定类型的对象
		session.getTransaction().commit();		
				
		student.setAge(88);//student状态 detached 
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.merge(student);//先从数据库里load数据进行比较后只更新变动的数据
		session2.getTransaction().commit();		
	}
	
	@org.junit.Test
	public void testUpdate5(){
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		//注意：里面的是HQL语句，不是SQL， 表名的位置变为对象名
		Query q = session.createQuery("update H08Teacher s set s.name='z5' where s.id=1");
		q.executeUpdate();
		session.getTransaction().commit();			
	}
	
	
	@org.junit.Test
	public void testClear(){
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		H08Student student = session.load(H08Student.class, pk);//根据主键从数据库中取对应的数据
		System.out.println(student.getAge());
		
		session.clear();//用于清空缓存，可以注释掉比较结果
		
		H08Student student2 = session.load(H08Student.class, pk);//根据主键从数据库中取对应的数据
		System.out.println(student2.getAge());
		session.getTransaction().commit();				
	}
	
	@org.junit.Test
	public void testFlush(){
		H08StudentPK pk = new H08StudentPK();
		pk.setId(3);
		pk.setName("Miku");
		
		Session session = sf.getCurrentSession();
		//session.setFlushMode(FlushMode.MANUAL);//控制session.flush()方法什么时候执行
		
		session.beginTransaction();
		H08Student student = session.load(H08Student.class, pk);//根据主键从数据库中取对应的数据
		System.out.println(student.getAge());
		
		student.setAge(11);
		
		session.flush();//强制写入
		student.setAge(22);
		
		session.getTransaction().commit();				
	}
}
