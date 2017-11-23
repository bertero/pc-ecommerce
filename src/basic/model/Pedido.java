package basic.model;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Usuario usuario;
	private int ano;
	private int mes;
	private int dia;

	public Pedido(int id, Cliente cliente, Usuario usuario) {
		this.id = id;
		this.cliente = cliente;
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
}
