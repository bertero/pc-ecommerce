package basic.model;

public class PecaDeComputador {

	private double preco;
	private String fabricante;
	
	public PecaDeComputador(String fabricante, double preco) {
		this.setFabricante(fabricante);
		this.setPreco(preco);
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
