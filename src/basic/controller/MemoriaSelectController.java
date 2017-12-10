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
@WebServlet("/memoria-select")
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
		List<Memoria> listaMemorias = MemoriaDAO.getInstance().getMemorias();
		Computador pc = (Computador)request.getSession().getAttribute("pc");
		
		for (Memoria mem : listaMemorias) {
			String id = "memoria" + mem.getId();
			int quant = Integer.parseInt(request.getParameter(id));
			for (int i = 0; i < quant; i++) pc.setMem(mem);
		}
		
		List<DiscoRigido> listaDiscosRigidos = DiscoRigidoDAO.getInstance().getDiscosRigidos();
		request.getSession().setAttribute("pc", pc);
		request.setAttribute("listaDiscosRigidos", listaDiscosRigidos);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/discoRigido.jsp");
        requestDispatcher.forward(request, response);
	}

}
