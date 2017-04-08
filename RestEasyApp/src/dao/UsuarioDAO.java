package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Usuario;
import hibernate.HibernateUtil;

public class UsuarioDAO extends GenericDao<Integer, Usuario>{

	private static UsuarioDAO instance;
	
	public static UsuarioDAO getInstance() {		
		instance = new UsuarioDAO();		
		return instance;
	}
	
	@Override
	public List<Usuario> getAll() throws SQLException {
		return super.getAll("Usuario.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Usuario.class;
	}

	@Override
	public Usuario find(Usuario entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getByMatricula(String matricula) throws SQLException{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Usuario usuario = null;

		try {

			String hql = "from Usuario as u" + " where u.matricula like :matricula";

			Query query = session.createQuery(hql);
			query.setParameter("matricula", "%" + matricula + "%");

			usuario = (Usuario) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {

			session.close();
		}

		return usuario;
	}
}
