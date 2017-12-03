package basic.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.*;
import basic.model.Computador;
import basic.model.ItemDePedido;
import basic.model.Pedido;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/memoria-select")
public class ComputadorQuantSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputadorQuantSelect () {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaPlacasMae", PlacaMaeDAO.getInstance().getPlacasMae());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/placaMae.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Computador pc = (Computador)request.getSession().getAttribute("pc");
		Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");		
		int quant = Integer.parseInt(request.getParameter("quantidadeComputador"));
		ItemDePedido item = new ItemDePedido(pedido, pc, quant, "computador");
		pedido.addItemDePedido(item);
		request.getSession().removeAttribute("pc");
		request.setAttribute("listaDeItens", pedido.getItensDePedido());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        requestDispatcher.forward(request, response);
	}

}
