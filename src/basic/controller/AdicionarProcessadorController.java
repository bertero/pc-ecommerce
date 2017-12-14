package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.ProcessadorDAO;
import basic.model.*;

import java.util.ArrayList;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/AdicionarProcessadorController")
public class AdicionarProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Processador> listaDeProcessador = new ArrayList<Processador>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarProcessadorController() {
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
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AdicionarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}


}
