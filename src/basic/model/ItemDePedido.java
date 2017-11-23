package basic.model;

public class ItemDePedido {
	private int id;
	private int quantidade;
	private Pedido pedido;
	private Produto prod;
	
	public ItemDePedido(int id, Pedido pedido, Produto prod, int quantidade) {
		this.id = id;
		this.pedido = pedido;
		this.prod = prod;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return prod;
	}

	public int getId() {
		return id;
	}

	public Pedido getIdPedido() {
		return pedido;
	}
	
	
}
