package basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String HOST = "localhost";
    private static Integer PORT = 4747;
    private static String DB = "mdb108";

    protected DAO() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected Connection getConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://" +
                HOST + ":" +
                PORT + "/" +
                DB + "?user=" +
                USER + "&password=" +
                PASSWORD
        );
    }

}
