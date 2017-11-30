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
@WebServlet("/confirmar-pedido")
public class ConfirmarPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarPedidoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
		PedidoDAO.getInstance().insertPedido(pedido);
		request.getSession().setAttribute("usuario", UsuarioDAO.getInstance().getUsuarioById(1));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoInit.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pageNotFound.jsp");
        requestDispatcher.forward(request, response);
	}

}
