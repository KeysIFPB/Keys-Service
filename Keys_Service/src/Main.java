import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Adm;
import hibernate.HibernateUtil;

public class Main {
	public static void main(String[] args) {

		Session session	= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Adm adm = new Adm("Thayanne", "111.111.111-11", "thayanne123");
		session.save(adm);
		session.getTransaction().commit();

	}
}