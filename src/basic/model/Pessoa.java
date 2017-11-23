package basic.model;

public class Pessoa {
	private int id;
	private String nome, email, endereco, telefone;
	
	public Pessoa(int id, String nome, String email, String endereco, String telefone) {
		this.id = id;
		this.nome = nome;
		this.setEmail(email);
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
