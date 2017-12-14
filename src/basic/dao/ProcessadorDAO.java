package basic.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import basic.model.Pedido;
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
    
    public void updateProcessador(Processador proc) {
        try {
            Connection connection = getConexao();

            String query = "UPDATE processador SET fabricante=?, modelo=?, preco=?, idSoquete=?, frequencia=? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, proc.getFabricante());
            preparedStatement.setString(2, proc.getModelo());
            preparedStatement.setDouble(3, proc.getPreco());
            preparedStatement.setInt(4, proc.getSoquete().getId());
            preparedStatement.setString(5, proc.getFrequencia());
            preparedStatement.setInt(6, proc.getId());

            ResultSet rs = preparedStatement.executeQuery();

            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return;
    }
    
    public static void insertProcessador(Processador proc) {
		final String query = "INSERT INTO processador (fabricante, modelo, idSoquete, frequencia, preco) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Connection connection = getConexao();
			try {
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, proc.getFabricante());
				statement.setString(2, proc.getModelo());
				statement.setInt(3, proc.getSoquete().getId());
				statement.setString(4, proc.getFrequencia());
				statement.setDouble(5, proc.getPreco());
				if (statement.executeUpdate() == 0) System.out.println("Insert Failed");
				else {					
					result = statement.getGeneratedKeys();
			        result.next();
				}
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("closing error");
					e.printStackTrace();
				}
			} catch (SQLException e) {
				System.out.println("insert error");
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
			System.out.println("connection error");
			e.printStackTrace();
		}
		return;
	}
    
}
