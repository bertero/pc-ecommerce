package basic.model;

public class DiscoRigido extends PecaDeComputador{
	private String tamanho, tipo;
	
	public DiscoRigido(String fabricante, double preco, int id, String tamanho,
			String tipo) {
		super(id, fabricante, preco);
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
	
}
