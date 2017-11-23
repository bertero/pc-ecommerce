package basic.model.pedido;

import basic.model.pessoa.Cliente;
import basic.model.pessoa.Usuario;

public class Pedido {
	int id;
	Cliente cliente;
	Usuario usuario;
	
	public Pedido(int id, Cliente cliente, Usuario usuario) {
		this.id = id;
		this.cliente = cliente;
		this.usuario = usuario;
	}
}
