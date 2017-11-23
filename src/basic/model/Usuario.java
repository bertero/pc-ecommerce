package basic.model;

public class Usuario extends Pessoa {
	private String login, senha;
	
	public Usuario(int id, String nome, String email, String endereco, String telefone, String login, String senha) {
		super(id, nome, email, endereco, telefone);
		this.login = login;
		this.senha = senha;
	}


	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
