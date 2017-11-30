package basic.model;

public class PecaDeComputador extends Produto{

	
	private String fabricante;
	
	public PecaDeComputador(int id, String fabricante, double preco) {
		super(id,preco);
		this.setFabricante(fabricante);
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}



}
