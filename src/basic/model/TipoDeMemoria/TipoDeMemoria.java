package basic.model.TipoDeMemoria;

public class TipoDeMemoria {

	private int idTipoDeMemoria;
	private String nome;

	
	
	public TipoDeMemoria(int idTipoDeMemoria, String nome) {
		this.idTipoDeMemoria = idTipoDeMemoria;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdTipoDeMemoria() {
		return idTipoDeMemoria;
	}


	
}