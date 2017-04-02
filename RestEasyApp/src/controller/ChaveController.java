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

import dao.ChaveDAO;
import entidade.Chave;

@Path("chave")
public class ChaveController {

	/**
	 * Cadastra a chave no sistema.
	 * 
	 * @param chave
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Chave chave) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de neg�cio e manipula��o de dados nesse ponto. As
		// informa��os devem ser associadas
		// nesse ponto ao biuld (response).

		try {

			int idChave = ChaveDAO.getInstance().insert(chave);

			chave.setId(idChave);

			builder.status(Response.Status.OK).entity(chave);

		} catch (SQLException e) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta.
		return builder.build();
	}

	/**
	 * Retorna todas as chaves cadastradas.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Chave> getAll() {

		// Retorno em formato de lista.
		// Desse modo o response sempre conter� o c�digo de resposta OK.
		List<Chave> chaves = new ArrayList<Chave>();

		try {

			// TODO: Regra de neg�cio e manipula��o de dados nesse ponto.
			chaves = ChaveDAO.getInstance().getAll();

		} catch (SQLException e) {

			// TODO: Tratar a exce��o.
		}

		// Ser� retornado ao cliente um conjunto de chaves no formato de Json.
		return chaves;
	}

	/**
	 * Recupera a chave cadastrado no sistema atrav�s do seu id.
	 * 
	 * @param idChave
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getChaveById(@PathParam("id") int idChave) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Regra de neg�cio e manipula��o de dados nesse ponto.
			Chave chave = ChaveDAO.getInstance().getById(idChave);

			if (chave != null) {

				// As informa��os associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(chave);

			} else {

				// Conte�do n�o encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}

	@PermitAll
	@GET
	@Path("/listar/sala/{sala}")
	@Produces("application/json")
	public Response getChaveBySala(@PathParam("sala") String sala) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Consultar a chave pela sala. Consulta dispon�vel na entidade
			// ChaveDAO.
			List<Chave> chaves = ChaveDAO.getInstance().getBySala(sala);

			if (!chaves.isEmpty()) {

				// As informa��os associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(chaves);

			} else {

				// Conte�do n�o encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}

}
