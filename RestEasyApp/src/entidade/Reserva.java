package entidade;

import javax.persistence.*;

import entidade.Usuario;
import entidade.Chave;

@Entity
@NamedQuery(name = "Reserva.getAll", query = "from Reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String horaReserva;
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

	public String getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
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
