package entidade;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Chave.getAll", query = "from Chave")
public class Chave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String sala;
	private boolean situacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
