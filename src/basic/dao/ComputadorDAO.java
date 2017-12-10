package basic.dao;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

import basic.model.*;

public class ComputadorDAO extends DAO {
    private static final ComputadorDAO instance = new ComputadorDAO();
    public ComputadorDAO() {
        super();
    }

    public static ComputadorDAO getInstance () {
        return instance;
    }

    private Computador createPCFromRow(ResultSet rs) throws SQLException {
    	Computador pc = new Computador();
    	pc.setPm(PlacaMaeDAO.getInstance().getPlacaMaeById(rs.getInt("idPlacaMae")));
    	pc.setProc(ProcessadorDAO.getInstance().getProcessadorById(rs.getInt("idProcessador")));
    	Memoria mem1 = MemoriaDAO.getInstance().getMemoriaById(rs.getInt("idMemoria1"));
    	Memoria mem2 = MemoriaDAO.getInstance().getMemoriaById(rs.getInt("idMemoria2"));
    	Memoria mem3 = MemoriaDAO.getInstance().getMemoriaById(rs.getInt("idMemoria3"));
    	Memoria mem4 = MemoriaDAO.getInstance().getMemoriaById(rs.getInt("idMemoria4"));
    	DiscoRigido hd1 = DiscoRigidoDAO.getInstance().getDiscoRigidoById(rs.getInt("idDiscoRigido1"));
    	DiscoRigido hd2 = DiscoRigidoDAO.getInstance().getDiscoRigidoById(rs.getInt("idDiscoRigido2"));
    	pc.setMem(mem1);
    	if (mem2 != null) pc.setMem(mem2);
    	if (mem3 != null) pc.setMem(mem3);
    	if (mem4 != null) pc.setMem(mem4);
    	pc.setHd(hd1);
    	if (hd2 != null) pc.setHd(hd2);
        return pc;
    }
    
    public Computador getPCById(int id) {
    	Computador pc = null;
        try {
            Connection connection = getConexao();

            String query = "SELECT * FROM computador WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pc = this.createPCFromRow(rs);
            }
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return pc;
    }
    
    public void insertPC(Computador pc) {
    	final String query = "INSERT INTO computador "
    			+ "(idPlacaMae, idProcessador, idMemoria1, idMemoria2, idMemoria3, idMemoria4, idDiscoRigido1, idDiscoRigido2) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int idPC = -1;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Connection connection = getConexao();
			try {
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				//mandatory
				statement.setInt(1, pc.getPm().getId());
				statement.setInt(2, pc.getProc().getId());
				statement.setInt(3, pc.getMem1().getId());
				statement.setInt(4, 0);
				statement.setInt(5, 0);
				statement.setInt(6, 0);
				statement.setInt(7, pc.getHd1().getId());
				statement.setInt(8, 0);

				//optional
				if (pc.getMem2() != null) statement.setInt(4, pc.getMem2().getId());
				if (pc.getMem3() != null) statement.setInt(5, pc.getMem3().getId());
				if (pc.getMem4() != null) statement.setInt(6, pc.getMem4().getId());
				if (pc.getHd2() != null)  statement.setInt(8, pc.getHd2().getId());
				if (statement.executeUpdate() == 0) System.out.println("Insert Failed");
				else {					
					result = statement.getGeneratedKeys();
			        result.next();
					idPC = result.getInt(1);
					pc.setId(idPC);
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
