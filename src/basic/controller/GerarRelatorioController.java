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
@WebServlet("/GerarRelatorioController")
public class GerarRelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerarRelatorioController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/GerarRelatorio.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mes = Integer.parseInt(request.getParameter("mes"))-1;
		request.setAttribute("listaDePedidosPorMes", PedidoDAO.getInstance().getPedidosPorMes(mes));
	
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/VisualizarRelatoriosView.jsp");
        requestDispatcher.forward(request, response);
	}

}
