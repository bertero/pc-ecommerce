package basic.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Usuario usuario;
	private int ano;
	private int mes;
	private int dia;
	private List<ItemDePedido> itensDePedido = new ArrayList<ItemDePedido>();

	public Pedido(Cliente cliente, Usuario usuario) {
		this.cliente = cliente;
		this.usuario = usuario;
	}
	
	public Pedido(int id, Cliente cliente, Usuario usuario, int dia, int mes, int ano) {
		this.id = id;
		this.cliente = cliente;
		this.usuario = usuario;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	//valores calculados
	public double getPrecoTotalDoPedido() {
		if (this.itensDePedido.isEmpty()) return 0;
		double valorTotal = 0;
		for (ItemDePedido itemPedido:this.itensDePedido) {
			if (itemPedido.getTipo() == "computador") {
				Computador pc = (Computador)itemPedido.getProduto();
				valorTotal += pc.calculaPreco() * itemPedido.getQuantidade();
			} else {
				PecaDeComputador peca = (PecaDeComputador)itemPedido.getProduto();
				valorTotal += peca.getPreco() * itemPedido.getQuantidade();
			}
		}
		return valorTotal * (1 - this.getDesconto());
	}
	
	public double getDesconto() {
		if (this.itensDePedido.isEmpty()) return 0;
		int quantPC = 0, quantPM = 0, quantProc = 0, quantMem = 0, quantHD = 0;
		for (ItemDePedido itemPedido : this.itensDePedido) {
			if (itemPedido.getTipo() == "computador") {
				quantPC += itemPedido.getQuantidade();
			} else {
				if (itemPedido.getTipo() == "placaMae")    quantPM += itemPedido.getQuantidade();
				if (itemPedido.getTipo() == "processador") quantProc += itemPedido.getQuantidade();
				if (itemPedido.getTipo() == "memoria")     quantMem += itemPedido.getQuantidade();
				if (itemPedido.getTipo() == "discoRigido") quantHD += itemPedido.getQuantidade();
			}
		}
		
		double desconto = 0;
		if (quantProc > 4 || quantHD > 4) desconto = 0.07;
		if (quantPM > 4)                  desconto = 0.08;
		if (quantMem > 7 || quantPC > 0)  desconto = 0.1;
		if (quantPC > 4)                  desconto = 0.15;
		
		return desconto;
	}
	
	public Date getDataDoPedido() throws ParseException
	{
		String anoString = String.valueOf(this.ano);
		String mesString = String.valueOf(this.mes);
		String diaString = String.valueOf(this.dia);
		String dataString = anoString+mesString+diaString;
		
		SimpleDateFormat dataFormater = new SimpleDateFormat("yyyy-mm-dd");
		Date data = null;
		try
		{
			 data = dataFormater.parse(dataString);
		}
		catch(ParseException e){e.printStackTrace();}
		
	
		return data;
	}

	public List<ItemDePedido> getItensDePedido() {
		return itensDePedido;
	}

	public void addItemDePedido(ItemDePedido item) {
		this.itensDePedido.add(item);
	}
	
	public void setItensDePedido(List<ItemDePedido> itens) {
		this.itensDePedido = itens;
	}
}
