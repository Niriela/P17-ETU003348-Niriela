package servlets;
import java.sql.*;

public class Connectivity {
    private Connection connect;

    //private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/depenses";
    //private static final String MYSQL_USER = "root";
    //private static final String MYSQL_PASSWORD = "";

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/db_s2_ETU003348";
    private static final String MYSQL_USER = "ETU003348";
    private static final String MYSQL_PASSWORD = "PZoa7enw";


    public Connectivity() {
    }

    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
 
            return this.connect;
        } catch (Exception e) {
            throw new Exception("Erreur lors de la connexion à la base : " + e.getMessage(), e);
        }
    }

}
