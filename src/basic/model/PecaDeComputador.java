package basic.model;

public class PecaDeComputador extends Produto{
	private double preco;
	private String fabricante;
	
	public PecaDeComputador(int id,String fabricante, double preco) {
		super();
		this.setId(id);
		this.preco = preco;
		this.fabricante = fabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
