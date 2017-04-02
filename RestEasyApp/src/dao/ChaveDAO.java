package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.*;

import entidade.Chave;
import dao.GenericDao;
import hibernate.HibernateUtil;

public class ChaveDAO extends GenericDao<Integer, Chave> {

	private static ChaveDAO instance;

	public static ChaveDAO getInstance() {
		instance = new ChaveDAO();
		return instance;
	}

	@Override
	public List<Chave> getAll() throws SQLException {
		return super.getAll("Chave.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Chave.class;
	}

	@Override
	public Chave find(Chave entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Chave> getBySala(String sala) throws SQLException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Chave> chaves = null;

		try {

			String hql = "from Chave as c" + " where c.sala like :sala";

			Query query = session.createQuery(hql);
			query.setParameter("sala", "%" + sala + "%");

			chaves = (List<Chave>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {

			session.close();
		}

		return chaves;
	}
}
