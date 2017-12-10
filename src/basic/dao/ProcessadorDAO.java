package basic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import basic.model.Processador;
import basic.model.Soquete;

public class ProcessadorDAO extends DAO {
    private static final ProcessadorDAO instance = new ProcessadorDAO();
    public ProcessadorDAO() {
        super();
    }

    public static ProcessadorDAO getInstance () {
        return instance;
    }

    private Processador createProcessadorFromRow(ResultSet rs) throws SQLException {
    	Soquete soquete = SoqueteDAO.getInstance().getSoqueteById(rs.getInt("idSoquete"));
        Processador processador = new Processador(rs.getInt("id"), rs.getString("modelo"), rs.getString("frequencia"), rs.getString("fabricante"), rs.getDouble("preco"), soquete);

        return processador;
    }

    public List<Processador> getProcessadores() {
        List<Processador> ListaProcessadores = new ArrayList<Processador>();

        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM processador ORDER BY preco ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	ListaProcessadores.add(this.createProcessadorFromRow(rs));
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ListaProcessadores;
    }

    public Processador getProcessadorById(int id) {
        Processador processador = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM processador WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                processador = this.createProcessadorFromRow(rs);
            }



            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return processador;
    }

    public void ApagarProcessador(int id)
    {
    	try
    	{
    		Connection con = getConexao();
    		String query = "DELETE FROM processador WHERE id = ?";
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		preparedStatement.setInt(1, id);
    		preparedStatement.executeQuery();
    		
    	}
    	catch(SQLException e){ e.printStackTrace();}
    }
    
    public List<Processador> getProcessadoresBySoquete(Soquete soq) {
        List<Processador> ListaProcessadores = new ArrayList<Processador>();

        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM processador WHERE idSoquete = ? ORDER BY id ASC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, soq.getId());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	ListaProcessadores.add(this.createProcessadorFromRow(rs));
            }

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return ListaProcessadores;
    }
    
}
