package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.model.*;
import basic.model.discoRigido.DiscoRigido;
import basic.model.placaMae.PlacaMae;

import java.util.ArrayList;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/montar-pedido")
public class MontarPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Processador> listaProcessadores = new ArrayList<Processador>();
	private ArrayList<PlacaMae> listaPlacasMae = new ArrayList<PlacaMae>();
	private ArrayList<Memoria> listaMemorias = new ArrayList<Memoria>();
	private ArrayList<DiscoRigido> listaDiscosRigidos = new ArrayList<DiscoRigido>();
	private Pedido pedido;
	private Cliente cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MontarPedidoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoInit.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpfCliente = request.getParameter("cpf");
		cliente = new Cliente(cpfCliente);
	}

}
