package basic.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	public double getPrecoTotalDoPedido()
	{
		double valorTotal = 0;
		for(ItemDePedido itemPedido:this.itensDePedido)
		{
			if (itemPedido.getTipo() == "computador") {
				Computador pc = (Computador)itemPedido.getProduto();
				if (itemPedido.getQuantidade() > 4) valorTotal += pc.calculaPreco() * 0.85;
				else valorTotal += pc.calculaPreco() * 0.9;
			} else {
				PecaDeComputador peca = (PecaDeComputador)itemPedido.getProduto();
				double desconto = 1;
				if (itemPedido.getTipo() == "memoria" && itemPedido.getQuantidade() > 7) desconto = 0.9;
				else if (itemPedido.getTipo() == "placaMae" && itemPedido.getQuantidade() > 4) desconto = 0.92;
				else if (itemPedido.getTipo() == "processador" && itemPedido.getQuantidade() > 4) desconto = 0.93;
				else if (itemPedido.getTipo() == "discoRigido" && itemPedido.getQuantidade() > 4) desconto = 0.93;
				valorTotal += peca.getPreco()*desconto;
			}
		}
		return valorTotal;
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
