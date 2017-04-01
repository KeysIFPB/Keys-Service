package entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_chave")	
	private Chave chave;

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
	
	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}
}
