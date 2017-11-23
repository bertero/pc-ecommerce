package basic.model;

public class ItemDePedido {
	private int id;
	private int quantidade;
	private Pedido pedido;
	private Produto prod;
	private String tipo;
	
	public ItemDePedido(int id, Pedido pedido, Produto prod, int quantidade, String tipo) {
		this.id = id;
		this.pedido = pedido;
		this.prod = prod;
		this.quantidade = quantidade;
		this.tipo = tipo;
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
	
	public String getTipo() {
		return tipo;
	}
	
	
}
