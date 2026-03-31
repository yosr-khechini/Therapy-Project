package utilitaires;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {
	
    private static Connection con = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtherapyproject", "root", "12345678");
            System.out.println("Connexion réussie à la base !");
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return con;
    }
}


