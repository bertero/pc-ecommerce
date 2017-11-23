package basic.model.placaMae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basic.model.DAO;
import basic.model.TipoDeMemoria.TipoDeMemoria;
import basic.model.TipoDeMemoria.TipoDeMemoriaDAO;

public class PlacaMaeDAO extends DAO {
	private static final PlacaMaeDAO instance = new PlacaMaeDAO();
	
    public PlacaMaeDAO() {
        super();
    }

    public static PlacaMaeDAO getInstance () {
        return instance;
    }

    private PlacaMae createPlacaMaeFromRow(ResultSet rs) throws SQLException {
    	TipoDeMemoria tipoDeMemoria = TipoDeMemoriaDAO.getInstance().getTipoDeMemoriaById(rs.getInt("tipoDeMemoria_id"));
        PlacaMae placaMae = new PlacaMae(rs.getInt("id"), rs.getInt("slots"), rs.getString("modelo"),  
        		rs.getString("fabricante"), rs.getDouble("preco"), tipoDeMemoria);

        return placaMae;
    }

    public List<PlacaMae> getPlacasMae() {
        List<PlacaMae> ListaPlacasMae = new ArrayList<PlacaMae>();

        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM placaMae ORDER BY preco ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	ListaPlacasMae.add(this.createPlacaMaeFromRow(rs));
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ListaPlacasMae;
    }

    public PlacaMae getPlacaMaeById(int id) {
        PlacaMae placaMae = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM placaMae WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                placaMae = this.createPlacaMaeFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return placaMae;
    }
}
