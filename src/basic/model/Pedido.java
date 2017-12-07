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
		 	valorTotal = valorTotal + itemPedido.getProduto().getPreco();
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
