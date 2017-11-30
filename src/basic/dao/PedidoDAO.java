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
    	Pedido pedido = new Pedido(rs.getInt("id"), cliente, usuario);
        return pedido;
    }

    public static int insertPedido(Pedido pedido) {
		final String query = "INSERT INTO pedidos VALUES (NULL, ?, ?);";
		final String queryID = "SELECT LAST_INSERT_ID();";
		int idPedido = -1;
		int idCliente = pedido.getCliente().getId();
		int idUsuario = pedido.getUsuario().getId();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Connection connection = getConexao();
			try {
				statement = connection.prepareStatement(query);
				statement.setInt(1, idCliente);
				statement.setInt(2, idUsuario);
				statement.execute();
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = connection.prepareStatement(queryID);
				result = statement.executeQuery();
				result.first();
				idPedido = result.getInt(1);
			} catch (SQLException e) {
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
			e.printStackTrace();
		}
		return idPedido;
	}
    
    public Pedido getPedidoById(int id) {
    	Pedido pedido = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM pedidos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pedido = this.createProcessadorFromRow(rs);
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }
    
    //    pega pedidos com um mes de Referencia para gerar relatorio
    public List<Pedido> getPedidosPorMes(String mesRef)
    {
    	int mesRefInt = Integer.parseInt(mesRef);
    	List<Pedido> ListaDePedidoPorMes = new ArrayList<Pedido>();
    	
    	try
    	{
    		Connection connection = getConexao();
    		String query = "SELECT * FROM pedidos WHERE mes = mesRefInt";
    		PreparedStatement prepared = connection.prepareStatement(query);
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
