package basic.dao;

import java.sql.*;

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
    	
    }

}
