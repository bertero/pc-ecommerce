package basic.dao;

import java.sql.*;

import basic.model.*;

public class SoqueteDAO extends DAO {
    private static final SoqueteDAO instance = new SoqueteDAO();
    public SoqueteDAO() {
        super();
    }

    public static SoqueteDAO getInstance () {
        return instance;
    }

    private Soquete createProcessadorFromRow(ResultSet rs) throws SQLException {
    	Soquete soquete = new Soquete(rs.getInt("id"), rs.getString("nome"));

        return soquete;
    }

    public Soquete getSoqueteById(int id) {
    	Soquete soquete = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM soquetes WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                soquete = this.createProcessadorFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return soquete;
    }

}
