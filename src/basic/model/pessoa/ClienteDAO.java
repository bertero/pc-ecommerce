package basic.model.pessoa;

import java.sql.*;
import basic.model.*;

public class ClienteDAO extends DAO {
    private static final ClienteDAO instance = new ClienteDAO();
    public ClienteDAO() {
        super();
    }

    public static ClienteDAO getInstance () {
        return instance;
    }

    private Cliente createProcessadorFromRow(ResultSet rs) throws SQLException {
    	Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("endereco"), rs.getString("telefone"));

        return cliente;
    }

    public Cliente getClienteByCpf(String cpf) {
    	Cliente cliente = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM clientes WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cliente = this.createProcessadorFromRow(rs);
            }
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
    
    public Cliente getClienteById(int id) {
    	Cliente cliente = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cliente = this.createProcessadorFromRow(rs);
            }
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

}
