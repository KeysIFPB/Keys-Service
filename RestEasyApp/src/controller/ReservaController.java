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
import dao.ReservaDAO;
import entidade.Chave;
import entidade.Reserva;

@Path("reserva")
public class ReservaController {

	/**
	 * Cadastra a reserva no sistema.
	 * 
	 * @param reserva
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/reservar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Reserva reserva) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de neg�cio e manipula��o de dados nesse ponto. As
		// informa��os devem ser associadas
		// nesse ponto ao biuld (response).

		try {

			int idReserva = ReservaDAO.getInstance().insert(reserva);

			Chave chave = reserva.getChave();

			chave.setSituacao(false);

			ChaveDAO.getInstance().update(chave);

			reserva.setId(idReserva);

			builder.status(Response.Status.OK).entity(reserva);

		} catch (SQLException e) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta.
		return builder.build();
	}

	@PermitAll
	@POST
	@Path("/devolver")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Reserva reserva) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de neg�cio e manipula��o de dados nesse ponto. As
		// informa��os devem ser associadas
		// nesse ponto ao biuld (response).
		try {

			Chave chave = reserva.getChave();

			chave.setSituacao(true);

			ChaveDAO.getInstance().update(chave);

			ReservaDAO.getInstance().update(reserva);

			builder.status(Response.Status.OK).entity(reserva);

		} catch (SQLException e) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta.
		return builder.build();
	}

	/**
	 * Retorna todas as reservas cadastradas.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Reserva> getAll() {

		// Retorno em formato de lista.
		// Desse modo o response sempre conter� o c�digo de resposta OK.
		List<Reserva> reservas = new ArrayList<Reserva>();

		try {

			// TODO: Regra de neg�cio e manipula��o de dados nesse ponto.
			reservas = ReservaDAO.getInstance().getAll();

		} catch (SQLException e) {

			// TODO: Tratar a exce��o.
		}

		// Ser� retornado ao cliente um conjunto de alunos no formato de Json.
		return reservas;
	}

	/**
	 * Recupera as reservas cadastradas no sistema atrav�s do seu id.
	 * 
	 * @param idReserva
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getReservaById(@PathParam("id") int idReserva) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Regra de neg�cio e manipula��o de dados nesse ponto.
			Reserva reserva = ReservaDAO.getInstance().getById(idReserva);

			if (reserva != null) {

				// As informa��os associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(reserva);

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
