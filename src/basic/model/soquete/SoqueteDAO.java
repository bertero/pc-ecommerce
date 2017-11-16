package basic.model.soquete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import basic.model.*;

/**
 * Created by rafa93br on 08/11/16.
 */
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
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM soquete WHERE id = ?";
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
