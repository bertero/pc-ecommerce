package basic.model.discoRigido;

import basic.model.PecaDeComputador;

public class DiscoRigido extends PecaDeComputador{
	private int id;
	private String tamanho, tipo;
	
	public DiscoRigido(String fabricante, double preco, int id, String tamanho,
			String tipo) {
		super(fabricante, preco);
		this.id = id;
		this.tamanho = tamanho;
		this.tipo = tipo;
	}

	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	
}
