package basic.model;

public class PecaDeComputador extends Produto{

	private double preco;
	private String fabricante;
	
	public PecaDeComputador(int id, String fabricante, double preco) {
		super(id);
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
