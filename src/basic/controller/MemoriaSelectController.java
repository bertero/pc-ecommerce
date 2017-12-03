package basic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.dao.*;
import basic.model.Computador;
import basic.model.Memoria;
import basic.model.Processador;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/processador-select")
public class MemoriaSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoriaSelectController () {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaPlacasMae", PlacaMaeDAO.getInstance().getPlacasMae());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/placaMae.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Processador> listaProcessadores = ProcessadorDAO.getInstance().getProcessadores();
		Computador pc = (Computador)request.getSession().getAttribute("pc");
		
		for (Processador proc : listaProcessadores) {
			String id = "processador_" + proc.getId(); 
			if (Integer.parseInt(request.getParameter(id)) > 0) {
				pc.setProc(proc);
			}
		}
		
		List<Memoria> listaMemorias = MemoriaDAO.getInstance().getMemoriasByTipo(pc.getPm().getTipoDeMemoria());
		request.getSession().setAttribute("pc", pc);
		request.setAttribute("listaMemorias", listaMemorias);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/memorias.jsp");
        requestDispatcher.forward(request, response);
	}

}
