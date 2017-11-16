package basic.model.pessoa;

public class Cliente extends Pessoa{
	private String cpf;
	
	public Cliente(int id, String nome, String cpf, String email, String endereco, String telefone) {
		super(id, nome, email, endereco, telefone);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
