package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dao.UsuarioDAO;
import entidade.Usuario;

@Path("usuario")
public class UsuarioController {

	/**
	 * Cadastra o usuario no sistema.
	 * 
	 * @param usuario
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Usuario usuario) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		//TODO: Regra de negócio e manipulação de dados nesse ponto. As informaçãos devem ser associadas
		// nesse ponto ao biuld (response).
		
		try {
			
			int idUsuario = UsuarioDAO.getInstance().insert(usuario);
			
			usuario.setId(idUsuario);
			
			builder.status(Response.Status.OK).entity(usuario);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Retorna todos os usuarios cadastrados.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Usuario> getAll() {
		
		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			//TODO: Regra de negócio e manipulação de dados nesse ponto.
			usuarios = UsuarioDAO.getInstance().getAll();
		
		} catch (SQLException e) {
			
			// TODO: Tratar a exceção.
		}
		
		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return usuarios;
	}
	
	/**
	 * Recupera o usuarios cadastrado no sistema através do seu id.
	 * 
	 * @param idUsuario
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getUsuarioById(@PathParam("id") int idUsuario) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			// Regra de negócio e manipulação de dados nesse ponto.
			Usuario usuario = UsuarioDAO.getInstance().getById(idUsuario); 
			
			if (usuario != null) {
				
				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(usuario);
				
			} else {
				
				// Conteúdo não encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
}
