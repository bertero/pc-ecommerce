package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basic.dao.DiscoRigidoDAO;
import basic.dao.MemoriaDAO;
import basic.dao.PlacaMaeDAO;
import basic.dao.ProcessadorDAO;
import basic.model.*;

import java.util.List;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/pecas-avulsas")
public class MontarPedidoPecasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pedido pedido = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MontarPedidoPecasController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaProcessadores", ProcessadorDAO.getInstance().getProcessadores());
		request.setAttribute("listaPlacasMae", PlacaMaeDAO.getInstance().getPlacasMae());
		request.setAttribute("listaMemorias", MemoriaDAO.getInstance().getMemorias());
		request.setAttribute("listaDiscosRigidos", DiscoRigidoDAO.getInstance().getDiscosRigidos());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoSelecionaPecas.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Processador> listaProcessadores = ProcessadorDAO.getInstance().getProcessadores();
		List<PlacaMae> listaPlacasMae = PlacaMaeDAO.getInstance().getPlacasMae();
		List<Memoria> listaMemorias = MemoriaDAO.getInstance().getMemorias();
		List<DiscoRigido> listaDiscosRigidos = DiscoRigidoDAO.getInstance().getDiscosRigidos();
		pedido = (Pedido)request.getSession().getAttribute("pedido");
		
		for (Processador processador : listaProcessadores) {
			String id = "processador" + processador.getId();
			int quantidade = 0;
			if (request.getParameter(id) != null && request.getParameter(id) != "") quantidade = Integer.parseInt(request.getParameter(id)); 
			if (quantidade > 0) {
				ItemDePedido novoItem = new ItemDePedido(pedido, processador, quantidade, "processador");
				pedido.addItemDePedido(novoItem);
			}
		}
		
		for (Memoria mem : listaMemorias) {
			String id = "memoria" + mem.getId();
			int quantidade = 0;
			if (request.getParameter(id) != null && request.getParameter(id) != "") quantidade = Integer.parseInt(request.getParameter(id));
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, mem, quantidade, "memoria"));
			}
		}
		
		for (PlacaMae pm : listaPlacasMae) {
			String id = "placaMae" + pm.getId();
			int quantidade = 0;
			if (request.getParameter(id) != null && request.getParameter(id) != "") quantidade = Integer.parseInt(request.getParameter(id));
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, pm, quantidade, "placaMae"));
			}
		}
		
		for (DiscoRigido hd : listaDiscosRigidos) {
			String id = "discoRigido" + hd.getId();
			int quantidade = 0;
			if (request.getParameter(id) != null && request.getParameter(id) != "") quantidade = Integer.parseInt(request.getParameter(id));
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, hd, quantidade, "discoRigido"));
			}
		}
		
		request.getSession().setAttribute("pedido", pedido);
		request.setAttribute("pedido", pedido);
		request.setAttribute("listaDeItens", pedido.getItensDePedido());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        requestDispatcher.forward(request, response);
	}

}
