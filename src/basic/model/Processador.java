package basic.model;

import basic.model.soquete.Soquete;

public class Processador extends PecaDeComputador{
	private int id;
	private String modelo, frequencia;
	private Soquete soquete;
	
	public Processador(int id, String modelo, String frequencia, String fabricante, double preco, Soquete soquete) {
		super(fabricante, preco);
		this.id = id;
		this.modelo = modelo;
		this.frequencia = frequencia;
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
	
	public void setSoquete(Soquete soquete) {
		this.soquete = soquete;
		return;
	}
}
