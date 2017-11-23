package basic.model.Memoria;

import basic.model.PecaDeComputador;
import basic.model.TipoDeMemoria.TipoDeMemoria;

public class Memoria extends PecaDeComputador{
	

	private String frequencia;
	private String tamanho;
	private  TipoDeMemoria tipoDeMemoria;


	
	
	public Memoria(String fabricante, double preco, int idMemoria, String frequencia, String tamanho,
			TipoDeMemoria tipoDeMemoria) {
		super(id,fabricante, preco);
		this.frequencia = frequencia;
		this.tamanho = tamanho;
		this.tipoDeMemoria = tipoDeMemoria;
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
	

}
