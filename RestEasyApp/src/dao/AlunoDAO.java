package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Aluno;

public class AlunoDAO extends GenericDao<Integer, Aluno>{

	private static AlunoDAO instance;
	
	public static AlunoDAO getInstance() {		
		instance = new AlunoDAO();		
		return instance;
	}
	
	@Override
	public List<Aluno> getAll() throws SQLException {
		return super.getAll("Aluno.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Aluno.class;
	}

	@Override
	public Aluno find(Aluno entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
