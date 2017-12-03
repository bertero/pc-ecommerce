package basic.model;

public class TipoDeMemoria {

	private int id;
	private String nome;

	
	
	public TipoDeMemoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}


	
}