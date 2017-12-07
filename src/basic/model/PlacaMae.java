package basic.model;

public class PlacaMae extends PecaDeComputador{
	private int slots;
	private String modelo;
	private TipoDeMemoria tipoDeMemoria;
	private Soquete soquete;

	public PlacaMae(String fabricante, double preco, int id, int slots,
			String modelo, TipoDeMemoria tipoDeMemoria, Soquete soquete) {
		super(id, fabricante, preco);
		this.setId(id);
		this.slots = slots;
		this.modelo = modelo;
		this.tipoDeMemoria = tipoDeMemoria;
		this.soquete = soquete;
	}

	public TipoDeMemoria getTipoDeMemoria() {
		return tipoDeMemoria;
	}

	public void setTipoDeMemoria(TipoDeMemoria tipoDeMemoria) {
		this.tipoDeMemoria = tipoDeMemoria;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Soquete getSoquete() {
		return soquete;
	}

	public void setSoquete(Soquete soquete) {
		this.soquete = soquete;
	}
	
}
