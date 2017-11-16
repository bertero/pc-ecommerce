package basic.model;

public class Soquete {
	private int id;
	private String nome;
	
	public Soquete(int id, String nome) {
		this.id = id;
		this.nome= nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nomeNovo) {
		this.nome = nomeNovo;
		return;
	}
}
