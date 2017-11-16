package basic.model.pessoa;

import java.sql.*;
import basic.model.*;

public class UsuarioDAO extends DAO {
    private static final UsuarioDAO instance = new UsuarioDAO();
    public UsuarioDAO() {
        super();
    }

    public static UsuarioDAO getInstance () {
        return instance;
    }

    private Usuario createProcessadorFromRow(ResultSet rs) throws SQLException {
    	Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("login"), rs.getString("senha"));
        return usuario;
    }

    public Usuario getUsuarioById(int id) {
    	Usuario usuario = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM soquete WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                usuario = this.createProcessadorFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
