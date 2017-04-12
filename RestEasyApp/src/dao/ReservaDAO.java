package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Reserva;
import hibernate.HibernateUtil;

public class ReservaDAO extends GenericDao<Integer, Reserva>{

	private static ReservaDAO instance;
	
	public static ReservaDAO getInstance() {		
		instance = new ReservaDAO();		
		return instance;
	}
	
	@Override
	public List<Reserva> getAll() throws SQLException {
		return super.getAll("Reserva.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Reserva.class;
	}

	@Override
	public Reserva find(Reserva entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
public Reserva findReservaById(int id) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Reserva reserva = null;
		
		try{
		
			String hql = "from Reserva r "
				+ "where r.id like :id";
			
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			
			reserva = (Reserva) query.uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return reserva;
	}
}
