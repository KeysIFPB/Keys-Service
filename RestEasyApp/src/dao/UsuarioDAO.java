package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Usuario;

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
}
