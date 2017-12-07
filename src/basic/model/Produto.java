package basic.model;

public class Produto {
	private int id;
	private double preco;
	
	public Produto(int id, double preco) 
	{
		this.id = id;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
