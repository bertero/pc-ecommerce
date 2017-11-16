package basic.model;

public class Processador {
	private int id;
	private String modelo, frequencia;
	private Soquete soquete;
	
	public Processador(int id, String modelo, String frequencia, Soquete soquete) {
		this.id = id;
		this.modelo = modelo;
		this.frequencia= frequencia;
		this.soquete = soquete;
	}
	
	public int getId() {
		return id;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modeloNovo) {
		this.modelo = modeloNovo;
		return;
	}
	
	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequenciaNova) {
		this.frequencia= frequenciaNova;
		return;
	}
	
	public Soquete getSoquete() {
		return soquete;
	}
}
