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
    	int idProd = rs.getInt("idProduto");
    	String tipo = rs.getString("tipo");
    	Produto prod;
    	
    	if (tipo == "processador")      prod = ProcessadorDAO.getInstance().getProcessadorById(idProd);
    	else if (tipo == "placaMae")    prod = PlacaMaeDAO.getInstance().getPlacaMaeById(idProd);
    	else if (tipo == "memoria")     prod = MemoriaDAO.getInstance().getMemoriaById(idProd);
    	else if (tipo == "discoRigido") prod = DiscoRigidoDAO.getInstance().getDiscoRigidoById(idProd);
    	else if (tipo == "computador") {
    		prod = ComputadorDAO.getInstance().getPCById(idProd);
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

	public void insertItensDePedido(Pedido pedido) {
		List<ItemDePedido> itens = pedido.getItensDePedido();
		PreparedStatement statement = null;
		final String query = "INSERT INTO itensDePedido VALUES (?, ?, ?, ?);";
		
		for (ItemDePedido item : itens) {
			if (item.getTipo() == "computador") {
				ComputadorDAO.getInstance().insertPC((Computador)item.getProduto());
			}
			try {
				Connection connection = getConexao();
				try {
					statement = connection.prepareStatement(query);
					statement.setInt(1, pedido.getId());
					statement.setInt(2, item.getProduto().getId());
					statement.setInt(2, item.getQuantidade());
					statement.setString(2, item.getTipo());
					statement.execute();
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
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
		}
	}

}
