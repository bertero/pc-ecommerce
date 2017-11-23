package basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    	int idProd;
    	int idProcessador = rs.getInt("idProcessador");
    	int idPlacaMae = rs.getInt("idPlacaMae");
    	int idMemoria = rs.getInt("idMemoria");
    	int idDiscoRigido = rs.getInt("idDiscoRigido");
    	int idComputador = rs.getInt("idComputador");
    	String tipo;
    	Produto prod;
    	
    	if (idProcessador != 0) {
    		idProd = idProcessador;
    		tipo = "processador";
    		prod = ProcessadorDAO.getInstance().getProcessadorById(idProd);
    	} else if (idPlacaMae != 0) {
    		idProd = idPlacaMae;
    		tipo = "placaMae";
    		prod = PlacaMaeDAO.getInstance().getPlacaMaeById(idProd);
    	} else if (idMemoria != 0) {
    		idProd = idMemoria;
    		tipo = "memoria";
    		prod = MemoriaDAO.getInstance().getMemoriaById(idProd);
    	} else if (idDiscoRigido != 0) {
    		idProd = idDiscoRigido;
    		tipo = "discoRigido";
    		prod = DiscoRigidoDAO.getInstance().getDiscoRigidoById(idProd);
    	} else if (idComputador != 0) {
    		idProd = idComputador;
    		tipo = "computador";
    		prod = ComputadorDAO.getInstance().getComputadorById(idComputador);
    	}
    	Pedido pedido = PedidoDAO.getInstance().getPedidoById(rs.getInt("idPedido"));
    	ItemDePedido itemDePedido = new ItemDePedido(rs.getInt("id"), pedido, prod, rs.getInt("quantidade"), tipo);
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
