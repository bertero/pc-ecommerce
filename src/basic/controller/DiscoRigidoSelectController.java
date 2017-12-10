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
import basic.model.DiscoRigido;
import basic.model.Memoria;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/disco-rigido-select")
public class DiscoRigidoSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscoRigidoSelectController() {
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
		List<DiscoRigido> listaDiscosRigidos = DiscoRigidoDAO.getInstance().getDiscosRigidos();
		Computador pc = (Computador)request.getSession().getAttribute("pc");
		
		for (DiscoRigido hd : listaDiscosRigidos) {
			String id = "discoRigido" + hd.getId();
			int quant = Integer.parseInt(request.getParameter(id));
			for (int i = 0; i < quant; i++) pc.setHd(hd);
		}
		
		request.getSession().setAttribute("pc", pc);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/quantidadeComputador.jsp");
        requestDispatcher.forward(request, response);
	}

}
