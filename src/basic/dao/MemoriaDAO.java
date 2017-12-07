package basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import basic.model.Memoria;
import basic.model.Processador;
import basic.model.TipoDeMemoria;


public class MemoriaDAO extends DAO {

	private static final MemoriaDAO instance = new MemoriaDAO();
	
	public MemoriaDAO()
	{
		super();
	}	
	public static MemoriaDAO getInstance()
	{
		return instance;
	}
	
	public Memoria createMemoriaFromRow(ResultSet rs) throws SQLException
	{
		TipoDeMemoria tipoDeMemoria = TipoDeMemoriaDAO.getInstance().getTipoDeMemoriaById(rs.getInt("tipoDeMemoria_id"));
		Memoria memoria = new Memoria(rs.getInt("id"), rs.getString("fabricante"), rs.getDouble("preco"), rs.getString("frequencia"),
				rs.getString("tamanho"), tipoDeMemoria );
		return memoria;
	}
	
	
	public List<Memoria> getMemorias()
	{
		List<Memoria> ListaDeMemorias = new ArrayList<Memoria>();
		try
		{
			Connection connection = getConexao();
			String query = "SELECT * FROM memorias ORDER BY preco ASC";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				ListaDeMemorias.add(createMemoriaFromRow(rs));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }
		return ListaDeMemorias;
		
	 }
	
	public List<Memoria> getMemoriasByTipo(TipoDeMemoria tipo)
	{
		List<Memoria> ListaDeMemorias = new ArrayList<Memoria>();
		try
		{
			Connection connection = getConexao();
			String query = "SELECT * FROM memorias WHERE tipo_de_memoria_id = ? ORDER BY id ASC";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, tipo.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				ListaDeMemorias.add(createMemoriaFromRow(rs));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }
		return ListaDeMemorias;
		
	 }
	public Memoria getMemoriaById(int id) {
		Memoria memoria = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM memorias WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                memoria = this.createMemoriaFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return memoria;
	}
	
}
