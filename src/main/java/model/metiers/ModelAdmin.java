package model.metiers;

import java.sql.SQLException;

import dao.DaoAdmin;
import model.entities.Administrateur;

public class ModelAdmin {

	private Administrateur admin;
	private DaoAdmin daoadmin = new DaoAdmin();
	public boolean autentifier() {
		try {
			return daoadmin.findAdmin(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	public void setAdmin(Administrateur administrateur) {
		this.admin = administrateur;
		
	}
	public Administrateur getAdmin() {
		return admin;
	}
}
