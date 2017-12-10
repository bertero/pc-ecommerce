package basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String HOST = "localhost";
    private static Integer PORT = 3306;
    private static String DB = "labSoft2017";

    protected DAO() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected static Connection getConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://" +
                HOST + ":" +
                PORT + "/" +
                DB + "?user=" +
                USER + "&password=" +
                PASSWORD
        );
    }

}
