package rocky.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rocky.domain.UserDetails;
import rocky.domain.UserProduct;
/*************
 * 
 * 
 * @author rockysaini
 * Tomcat servlet hibernate mysql project 
 *
 */
public class HibernateUtility {

	public static SessionFactory sf;

	private HibernateUtility(){	
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (sf == null) {
			sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserDetails.class).addAnnotatedClass(UserProduct.class).buildSessionFactory();
			Session session=sf.openSession();
			return sf;
		}
		return sf;
	}
}
