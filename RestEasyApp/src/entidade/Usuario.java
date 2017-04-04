package entidade;

import java.util.List;

import javax.persistence.*;
import entidade.Chave;

@Entity
@NamedQuery(name = "Usuario.getAll", query = "from Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String matricula;
	private String horaReserva;
	private String horaDevolucao;

	@ManyToMany
	@JoinTable(name = "reserva", joinColumns = { @JoinColumn(name = "fk_id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_id_chave") })
	private List<Chave> chaves;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public List<Chave> getChaves() {
		return chaves;
	}

	public void setChaves(List<Chave> chaves) {
		this.chaves = chaves;
	}
}
