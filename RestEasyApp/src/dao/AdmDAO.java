package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Adm;
import hibernate.HibernateUtil;

public class AdmDAO extends GenericDao<Integer, Adm>{

	private static AdmDAO instance;
	
	public static AdmDAO getInstance() {		
		instance = new AdmDAO();		
		return instance;
	}
	
	@Override
	public List<Adm> getAll() throws SQLException {
		return super.getAll("Adm.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Adm.class;
	}

	@Override
	public Adm find(Adm entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Adm getByEmail(String email) throws SQLException{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Adm adm = null;

		try {

			String hql = "from Adm as a" + " where a.email like :email";

			Query query = session.createQuery(hql);
			query.setParameter("email", "%" + email + "%");

			adm = (Adm) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {

			session.close();
		}

		return adm;
	}
}
