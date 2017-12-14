package basic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import basic.model.*;

public class PedidoDAO extends DAO {
    private static final PedidoDAO instance = new PedidoDAO();
    public PedidoDAO() {
        super();
    }

    public static PedidoDAO getInstance () {
        return instance;
    }

    private Pedido createProcessadorFromRow(ResultSet rs) throws SQLException {
    	Cliente cliente = ClienteDAO.getInstance().getClienteById(rs.getInt("idCliente"));
    	Usuario usuario = UsuarioDAO.getInstance().getUsuarioById(rs.getInt("idUsuario"));
    	Pedido pedido = new Pedido(rs.getInt("id"), cliente, usuario, rs.getInt("dia"), rs.getInt("mes"), rs.getInt("ano"));
    	pedido.setItensDePedido(ItemDePedidoDAO.getInstance().getItensDePedidoByIdPedido(pedido));
        return pedido;
    }

    public static int insertPedido(Pedido pedido) {
		final String query = "INSERT INTO pedido (idCliente, idUsuario, dia, mes, ano) VALUES (?, ?, ?, ?, ?);";
		int idCliente = pedido.getCliente().getId();
		int idUsuario = pedido.getUsuario().getId();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int idPedido = -1;
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Connection connection = getConexao();
			try {
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, idCliente);
				statement.setInt(2, idUsuario);
				statement.setInt(3, dia);
				statement.setInt(4, mes);
				statement.setInt(5, ano);
				if (statement.executeUpdate() == 0) System.out.println("Insert Failed");
				else {					
					result = statement.getGeneratedKeys();
			        result.next();
					idPedido = result.getInt(1);
					pedido.setId(idPedido);
				}
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("closing error");
					e.printStackTrace();
				}
				statement = connection.prepareStatement(query);
				ItemDePedidoDAO.getInstance().insertItensDePedido(pedido);
			} catch (SQLException e) {
				System.out.println("insert error");
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("connection error");
			e.printStackTrace();
		}
		return idPedido;
	}
    
    public Pedido getPedidoById(int id) {
    	Pedido pedido = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM pedido WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            connection.close();
            
            if (rs.next()) {
                pedido = this.createProcessadorFromRow(rs);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }
    
    //    pega pedidos com um mes de Referencia para gerar relatorio
    public List<Pedido> getPedidosPorMes(int mesRefInt) {
    	List<Pedido> ListaDePedidoPorMes = new ArrayList<Pedido>();
    	
    	try
    	{
    		Connection connection = getConexao();
    		String query = "SELECT * FROM pedido WHERE mes = ?";
    		PreparedStatement prepared = connection.prepareStatement(query);
    		prepared.setInt(1, mesRefInt);
    		ResultSet result = prepared.executeQuery();
    		while(result.next())
    		{
    			ListaDePedidoPorMes.add(this.createProcessadorFromRow(result));
    		}
    		connection.close();
    	} catch(SQLException e) {
            e.printStackTrace();
        }

        return ListaDePedidoPorMes;
    	
    	
    }

}
