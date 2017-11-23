package basic.model.discoRigido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basic.model.DAO;

public class DiscoRigidoDAO extends DAO{
	private static final DiscoRigidoDAO instance = new DiscoRigidoDAO();
    public DiscoRigidoDAO() {
        super();
    }

    public static DiscoRigidoDAO getInstance () {
        return instance;
    }

    private DiscoRigido createDiscoRigidoFromRow(ResultSet rs) throws SQLException {
    	DiscoRigido discoRigido = new DiscoRigido(rs.getString("fabricante"), rs.getDouble("preco"), 
    			rs.getInt("id"), rs.getString("tamanho"), rs.getString("tipo"));

        return discoRigido;
    }

    public List<DiscoRigido> getDiscosRigido() {
        List<DiscoRigido> ListaDiscosRigido = new ArrayList<DiscoRigido>();

        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM discoRigido ORDER BY preco ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	ListaDiscosRigido.add(this.createDiscoRigidoFromRow(rs));
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ListaDiscosRigido;
    }

    public DiscoRigido getDiscoRigidoById(int id) {
    	DiscoRigido discoRigido = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM discoRigido WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	discoRigido = this.createDiscoRigidoFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return discoRigido;
    }
}
