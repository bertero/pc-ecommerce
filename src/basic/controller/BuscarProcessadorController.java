package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.PedidoDAO;
import basic.dao.ProcessadorDAO;
import basic.model.*;
import basic.model.soquete.Usuario;

import java.util.ArrayList;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/BuscarProcessadorController")
public class BuscarProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Processador> listaDeProcessador = new ArrayList<Processador>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProcessadorController() {
        super();

  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BuscarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("processadorProcurado", ProcessadorDAO.getInstance().getProcessadorById(Integer.parseInt(request.getParameter("id"))));
	
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/EditarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}


}