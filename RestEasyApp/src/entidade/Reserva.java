package entidade;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import entidade.Usuario;
import entidade.Chave;

@Entity
@NamedQuery(name = "Reserva.getAll", query = "from Reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	Date d = new Date();
	
	private String dataReserva = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

	private String horaRetirada;
	private String horaDevolucao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Chave chave;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraReserva(String horaRetirada) {
		this.horaRetirada = horaRetirada;
	}

	public String getHoraDevolucao() {
		return horaDevolucao;
	}

	public void setHoraDevolucao(String horaDevolucao) {
		this.horaDevolucao = horaDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}
}
