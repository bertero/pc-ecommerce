package basic.model;

public class Memoria extends PecaDeComputador{
	

	private String frequencia;
	private String tamanho;
	private  TipoDeMemoria tipoDeMemoria;


	
	
	public Memoria(int id, String fabricante, double preco, String frequencia, String tamanho,
			TipoDeMemoria tipoDeMemoria) {
		super(id,fabricante, preco);
		this.frequencia = frequencia;
		this.tamanho = tamanho;
		this.setTipoDeMemoria(tipoDeMemoria);
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public TipoDeMemoria getTipoDeMemoria() {
		return tipoDeMemoria;
	}
	public void setTipoDeMemoria(TipoDeMemoria tipoDeMemoria) {
		this.tipoDeMemoria = tipoDeMemoria;
	}
	

}
