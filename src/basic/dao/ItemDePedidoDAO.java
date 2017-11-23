package basic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import basic.model.*;

public class ItemDePedidoDAO extends DAO {
    private static final ItemDePedidoDAO instance = new ItemDePedidoDAO();
    public ItemDePedidoDAO() {
        super();
    }

    public static ItemDePedidoDAO getInstance () {
        return instance;
    }

    private ItemDePedido createItemDePedidoFromRow(ResultSet rs) throws SQLException {
    	Pedido pedido = PedidoDAO.getInstance().getPedidoById(rs.getInt("idPedido"));
    	ItemDePedido itemDePedido = new ItemDePedido(rs.getInt("id"), pedido, prod, rs.getInt("quantidade"));
        return itemDePedido;
    }

    public int insertItemDePedido(Pedido pedido, Produto produto, int quantidade) {
		final String query = "INSERT INTO itensDePedidos VALUES (NULL, ?, ?, ?);";
		final String queryID = "SELECT LAST_INSERT_ID();";
		int idItemDePedido = -1;
		int idPedido = pedido.getId();
		int idProduto = produto.getId();
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Connection connection = getConexao();
			try {
				statement = connection.prepareStatement(query);
				statement.setInt(1, idPedido);
				statement.setInt(2, idProduto);
				statement.setInt(3, quantidade);
				statement.execute();
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement = connection.prepareStatement(queryID);
				result = statement.executeQuery();
				result.first();
				idItemDePedido = result.getInt(1);
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
		return idItemDePedido;
	}
    
    public List<ItemDePedido> getItensDePedidoByIdPedido(Pedido pedido) {
        List<ItemDePedido> itensDePedido = new ArrayList<ItemDePedido>();
        int idPedido = pedido.getId();
        
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM itensdepedidos WHERE idPedido = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPedido);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	itensDePedido.add(this.createItemDePedidoFromRow(rs));
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return itensDePedido;
    }
    
    public ItemDePedido getItemDePedidoById(int id) {
    	ItemDePedido itemDePedido = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM itensDePedidos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                itemDePedido = this.createItemDePedidoFromRow(rs);
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return itemDePedido;
    }

}
