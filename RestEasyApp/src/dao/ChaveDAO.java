package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Chave;
import dao.GenericDao;

public class ChaveDAO extends GenericDao<Integer, Chave>{

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

}
