package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basic.model.*;
import basic.model.soquete.Soquete;

import java.util.ArrayList;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/ProcessadorController")
public class ProcessadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Processador> listaDeProcessador = new ArrayList<Processador>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessadorController() {
        super();
        Soquete soqueteUnico     = new Soquete(1, "soqueteUnico");
        Processador processador  = new Processador(1, "modeloA", "2.4", soqueteUnico);
        Processador processadorA = new Processador(2, "modeloB", "2.4", soqueteUnico);
        Processador processadorB = new Processador(3, "modeloC", "3.0", soqueteUnico);
        
        listaDeProcessador.add(processador);
        listaDeProcessador.add(processadorA);
        listaDeProcessador.add(processadorB);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		if (request.getParameter("id") == null) {
			request.setAttribute("lista", listaDeProcessador);
			requestDispatcher = getServletContext().getRequestDispatcher("/listaDeProcessador.jsp");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			for(Processador p : listaDeProcessador){
			    if (p.getId() == id) request.setAttribute("processador", p);
			}
			requestDispatcher = getServletContext().getRequestDispatcher("/processadorDetalhado.jsp");
		}
		
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
