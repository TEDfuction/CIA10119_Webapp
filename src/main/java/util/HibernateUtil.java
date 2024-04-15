package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static final SessionFactory sessionFactory = createSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory() {
		try {
			//載入系統組態檔
			registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
			//創建Session工廠然後移到class HibernateUtil
			SessionFactory sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();

			return sessionFactory;

		}catch(Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static void shutdown() {
		if (registry != null)
			StandardServiceRegistryBuilder.destroy(registry);
	}

}