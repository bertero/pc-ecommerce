package basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static String USER = "t1g7";
    private static String PASSWORD = "x$Hk_?rX";
    private static String HOST = "143.107.102.5";
    private static Integer PORT = 3306;
    private static String DB = "t1g7";

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
