package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Adm.getAll", query = "from Adm")
public class Adm {

	@Id
	@GeneratedValue
	private int id;

	private int matricula;
	private String nome;
	private String email;
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void settricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Adm() {
	}

	public Adm(String nome, String email, int matricula, String senha) {
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.senha = senha;
	}
}