package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entities.Therapist;
import utilitaires.SingletonConnexion;

public class DaoTherapist {
	private Connection con = SingletonConnexion.getConnection();

	public boolean addTherapist(Therapist therapist) {
        String sql = "INSERT INTO therapists (name, surname, speciality, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, therapist.getName());
            ps.setString(2, therapist.getSurname());
            ps.setString(3, therapist.getSpeciality());
            ps.setString(4, therapist.getEmail());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0; // true if at least one row was inserted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

	}
}
