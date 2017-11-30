package basic.model;

public class PecaDeComputador extends Produto{

	
	private String fabricante;
	
	public PecaDeComputador(String fabricante, double preco) {
		super();
		this.setPreco(preco);
		this.fabricante = fabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}



}
