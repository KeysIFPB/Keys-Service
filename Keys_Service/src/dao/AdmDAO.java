package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Adm;

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
}
