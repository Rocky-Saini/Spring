package rocky.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rocky.controller.HibernateUtility;
import rocky.domain.UserProduct;
/*************
 * 
 * 
 * @author rockysaini
 * Tomcat servlet hibernate mysql project 
 *
 */
public class ValidateUsername {
	public static Session fetch(String username,String password){
		
	Session session=HibernateUtility.getSessionFactory().getCurrentSession();	
	Transaction tx=session.beginTransaction();
	TypedQuery<UserProduct> q1=session.createQuery("from UserDetails where username=:uname and password=:pwd");
	q1.setParameter("uname", username);
	q1.setParameter("pwd", password);

	List<UserProduct> l=q1.getResultList();
	tx.commit();
	if(l.size()==1)
		return session;
	return null;
	
	}
}
