package basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basic.model.*;
import basic.model.pessoa.Cliente;
import basic.model.pessoa.ClienteDAO;
import basic.model.pessoa.Usuario;
import basic.model.pessoa.UsuarioDAO;
import basic.model.processador.*;
import basic.model.discoRigido.*;
import basic.model.memoria.*;
import basic.model.pedido.Pedido;
import basic.model.pedido.PedidoDAO;

import java.util.List;

/**
 * Servlet implementation class ProcessadorController
 */
@WebServlet("/pecas-selecionadas")
public class MontarPedidoPecasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Processador> listaProcessadores = ProcessadorDAO.getInstance().getProcessadores();
	private List<PlacaMae> listaPlacasMae = PlacaMaeDAO.getInstance().getProcessadores();
	private List<Memoria> listaMemorias = MemoriaDAO.getInstance().getProcessadores();
	private List<DiscoRigido> listaDiscosRigidos = DiscoRigidoDAO.getInstance().getProcessadores();
	private Pedido pedido;
	private Cliente cliente;
	private Usuario usuario = UsuarioDAO.getInstance().getUsuarioById(1);
       
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
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		pedido = PedidoDAO.getInstance().getPedidoById(idPedido);
		
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/montarPedidoSelecionaPecas.jsp");
        requestDispatcher.forward(request, response);
	}

}
