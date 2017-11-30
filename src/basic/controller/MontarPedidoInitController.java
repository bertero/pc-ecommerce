package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.*;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/montar-pedido")
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
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoInit.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cpfCliente", request.getParameter("cpfCliente"));
		request.setAttribute("listaProcessadores", ProcessadorDAO.getInstance().getProcessadores());
		request.setAttribute("listaPlacasMae", PlacaMaeDAO.getInstance().getPlacasMae());
		request.setAttribute("listaMemorias", MemoriaDAO.getInstance().getMemorias());
		request.setAttribute("listaDiscosRigidos", DiscoRigidoDAO.getInstance().getDiscosRigidos());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoSelecionaPecas.jsp");
        requestDispatcher.forward(request, response);
	}

}
