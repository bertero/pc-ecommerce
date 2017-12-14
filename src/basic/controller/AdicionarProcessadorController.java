package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.ProcessadorDAO;
import basic.dao.SoqueteDAO;
import basic.model.*;

import java.util.ArrayList;
import java.util.Random;

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
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AdicionarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = null, fabricante = null, soqueteNome = null, frequencia = null;
		Soquete soquete = null;
		Double preco = 0.0;
		if (request.getParameter("modelo") != "" && request.getParameter("modelo") != null) modelo = (request.getParameter("modelo"));
	    if (request.getParameter("fabricante") != "" && request.getParameter("fabricante") != null) fabricante = (request.getParameter("fabricante"));
	    if (request.getParameter("soquete") != "" && request.getParameter("soquete") != null) soquete = (SoqueteDAO.getInstance().getSoqueteByName(request.getParameter("soquete")));
	    if (request.getParameter("frequencia") != "" && request.getParameter("frequencia") != null) frequencia = (request.getParameter("frequencia"));
	    if (request.getParameter("preco") != "" && request.getParameter("preco") != null && Double.parseDouble(request.getParameter("preco")) > 0) preco = (Double.parseDouble(request.getParameter("preco")));
		
	    Random r = new Random();
	    int id = r.nextInt(900-100) + 100;
	    
	    Processador proc = new Processador(id, modelo, frequencia, fabricante, preco, soquete);
	    
	    
	    
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BuscarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}


}
