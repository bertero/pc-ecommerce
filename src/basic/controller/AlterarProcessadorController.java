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

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/AlterarProcessadorController")
public class AlterarProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Processador> listaDeProcessador = new ArrayList<Processador>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProcessadorController() {
        super();

  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AlterarProcessador.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Processador processador = (Processador) request.getSession().getAttribute("processadorProcurado");
	    
	    if (request.getParameter("modelo") != "" && request.getParameter("modelo") != null) processador.setModelo(request.getParameter("modelo"));
	    if (request.getParameter("fabricante") != "" && request.getParameter("fabricante") != null) processador.setFabricante(request.getParameter("fabricante"));
	    if (request.getParameter("soquete") != "" && request.getParameter("soquete") != null) processador.setSoquete(SoqueteDAO.getInstance().getSoqueteByName(request.getParameter("soquete")));
	    if (request.getParameter("frequencia") != "" && request.getParameter("frequencia") != null) processador.setFrequencia(request.getParameter("frequencia"));
	    if (request.getParameter("preco") != "" && request.getParameter("preco") != null && Double.parseDouble(request.getParameter("preco")) > 0) processador.setPreco(Double.parseDouble(request.getParameter("preco")));
	    
	    ProcessadorDAO.getInstance().updateProcessador(processador);
	    
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inicio.jsp");
        requestDispatcher.forward(request, response);
	}


}
