package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import basic.dao.ClienteDAO;
import basic.dao.DiscoRigidoDAO;
import basic.dao.MemoriaDAO;
import basic.dao.PlacaMaeDAO;
import basic.dao.ProcessadorDAO;
import basic.dao.UsuarioDAO;
import basic.model.*;

import java.util.List;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/pecas-selecionadas")
public class MontarPedidoPecasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
       
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
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pageNotFound.jsp");
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
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente"); 
		pedido = new Pedido(cliente, usuario);
		for (Processador processador : listaProcessadores) {
			String id = "processador_" + processador.getId();
			int quantidade = Integer.parseInt(request.getParameter(id)); 
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, processador, quantidade, "processador"));
			}
		}
		
		for (Memoria mem : listaMemorias) {
			String id = "memoria_" + mem.getId();
			int quantidade = Integer.parseInt(request.getParameter(id)); 
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, mem, quantidade, "memoria"));
			}
		}
		
		for (PlacaMae pm : listaPlacasMae) {
			String id = "placaMae_" + pm.getId();
			int quantidade = Integer.parseInt(request.getParameter(id)); 
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, pm, quantidade, "placaMae"));
			}
		}
		
		for (DiscoRigido hd : listaDiscosRigidos) {
			String id = "processador_" + hd.getId();
			int quantidade = Integer.parseInt(request.getParameter(id)); 
			if (quantidade > 0) {
				pedido.addItemDePedido(new ItemDePedido(pedido, hd, quantidade, "discoRigido"));
			}
		}
		
		request.getSession().setAttribute("pedido", pedido);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        requestDispatcher.forward(request, response);
	}

}
