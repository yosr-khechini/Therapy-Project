package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Administrateur;
import utilitaires.SingletonConnexion; 

public class DaoAdmin{
	private Connection con = SingletonConnexion.getConnection();

	public boolean findAdmin(Administrateur admin) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from administrateur where login = '" + admin.getLogin() + "' and password = '" + admin.getPassword() + "'");
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		
		return false; 
	}
	

}
