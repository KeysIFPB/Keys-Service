package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Reserva;

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
}
