	package basic.model;

public class Computador extends Produto{
	private PlacaMae pm;
	
	public Computador() {
		super();
	}

	public PlacaMae getPm() {
		return pm;
	}

	public void setPm(PlacaMae pm) {
		this.pm = pm;
	}
}
