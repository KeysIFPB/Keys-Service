import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Adm;
import entidade.Aluno;
import hibernate.HibernateUtil;

public class Main {
	public static void main(String[] args) {

		Session session	= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Adm adm = new Adm("Thayanne", "thayannevls@gmail.com", "thaylinda123");
		Aluno aluno = new Aluno("Rayla", "20141004029");
		session.save(adm);
		session.save(aluno);
		session.getTransaction().commit();

	}
}