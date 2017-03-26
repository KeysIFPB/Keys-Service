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

import entidade.Adm;
import dao.AdmDAO;

@Path("adm")
public class AdmController {
	/**
	 * Cadastra o adm no sistema.
	 * 
	 * @param adm
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Adm adm) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		//TODO: Regra de negócio e manipulação de dados nesse ponto. As informaçãos devem ser associadas
		// nesse ponto ao biuld (response).
		
		try {
			
			int idAdm = AdmDAO.getInstance().insert(adm);
			
			adm.setId(idAdm);
			
			builder.status(Response.Status.OK).entity(adm);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Retorna todos os adms cadastrados.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Adm> getAll() {
		
		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Adm> adms = new ArrayList<Adm>();
		
		try {
			
			//TODO: Regra de negócio e manipulação de dados nesse ponto.
			adms = AdmDAO.getInstance().getAll();
		
		} catch (SQLException e) {
			
			// TODO: Tratar a exceção.
		}
		
		// Será retornado ao cliente um conjunto de adms no formato de Json.
		return adms;
	}
	
	/**
	 * Recupera o adms cadastrado no sistema através do seu id.
	 * 
	 * @param idAdm
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getAdmById(@PathParam("id") int idAdm) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			// Regra de negócio e manipulação de dados nesse ponto.
			Adm adm = AdmDAO.getInstance().getById(idAdm); 
			
			if (adm != null) {
				
				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(adm);
				
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
