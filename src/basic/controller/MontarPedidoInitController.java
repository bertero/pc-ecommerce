package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.*;
import basic.model.Cliente;
import basic.model.Pedido;
import basic.model.Usuario;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet({"/", "", "/montar-pedido"})
public class MontarPedidoInitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MontarPedidoInitController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("usuario", UsuarioDAO.getInstance().getUsuarioById(1));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoInit.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = ClienteDAO.getInstance().getClienteByCpf(request.getParameter("cpfCliente"));
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Pedido pedido = new Pedido(cliente, usuario);
		request.getSession().setAttribute("pedido", pedido);
		request.setAttribute("listaDeItens", pedido.getItensDePedido());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        requestDispatcher.forward(request, response);
	}

}
