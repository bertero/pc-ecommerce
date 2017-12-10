package basic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import basic.model.TipoDeMemoria;

public class TipoDeMemoriaDAO extends DAO {

	public static final TipoDeMemoriaDAO instance = new TipoDeMemoriaDAO();
	
	public TipoDeMemoriaDAO()
	{
		super();
	}
	
	public static TipoDeMemoriaDAO getInstance()
	{
		return instance;
	}
	
	public TipoDeMemoria CreateTipoDememoriaFromRow(ResultSet rs)throws SQLException
	{
		TipoDeMemoria tipoDeMemoria = new TipoDeMemoria(rs.getInt("id"), rs.getString("nome"));
		return tipoDeMemoria;
	}
	
	public TipoDeMemoria getTipoDeMemoriaById(int id)
	{
		TipoDeMemoria tipoDeMemoria = null;
		try
		{
			Connection connection = getConexao();
			String query = "SELECT * FROM tipoDeMemoria WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        if(rs.next())
	        {
	        	tipoDeMemoria = this.CreateTipoDememoriaFromRow(rs);
	        }
	        connection.close();
		}catch(SQLException e) {
            e.printStackTrace();
        }
		return tipoDeMemoria;
	}
	
	
	
}
