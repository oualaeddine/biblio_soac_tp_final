package soac.miniprojet.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnector {

    private static final String
            db_name = "tp_soac",
            host = "localhost",
            port = "3306",
            user = "root",
            pass = "";

 /*  private static final String
            db_name = "soc_imm",
            host = "localhost",
            port = "3306",
            user = "root",
            pass = "";*/

    private static final String conn = "jdbc:mysql://" + host + ":" + port + "/" + db_name + "?autoReconnect=true&useUnicode=yes";
    private static Connection connexion;

    DbConnector() {
    }

    public static void createConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connexion == null)
                connexion = DriverManager.getConnection(conn, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
            connexion = null;
        }
    }

    public static Statement getStatment() {
        try {
            return connexion.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}