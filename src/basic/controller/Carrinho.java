package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.*;
import basic.model.Pedido;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet({"/carrinho"})
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrinho() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
		RequestDispatcher requestDispatcher = null;
		if (pedido != null) {
			request.setAttribute("listaDeItens", pedido.getItensDePedido());
			requestDispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
		} else {
			request.getSession().setAttribute("usuario", UsuarioDAO.getInstance().getUsuarioById(1));
			requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoInit.jsp");
		}
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
