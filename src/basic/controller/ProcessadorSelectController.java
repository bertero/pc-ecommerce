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
import basic.model.PlacaMae;
import basic.model.Processador;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/processador-select")
public class ProcessadorSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessadorSelectController () {
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
		List<PlacaMae> listaPlacasMae = PlacaMaeDAO.getInstance().getPlacasMae();
		Computador pc = new Computador();
		List<Processador> listaProcessadores = null;
		
		for (PlacaMae pm : listaPlacasMae) {
			String id = "placaMae_" + pm.getId();
			int selecionada = Integer.parseInt(request.getParameter(id)); 
			if (selecionada > 0) {
				pc.setPm(pm);
				listaProcessadores = ProcessadorDAO.getInstance().getProcessadoresBySoquete(pm.getSoquete());
			}
		}
		
		 
		request.getSession().setAttribute("pc", pc);
		request.setAttribute("listaProcessadores", listaProcessadores);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/processador.jsp");
        requestDispatcher.forward(request, response);
	}

}
