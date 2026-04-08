package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Patient;
import utilitaires.SingletonConnexion;

public class DaoPatient {
	private Connection con = SingletonConnexion.getConnection();

	public boolean addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, surname, phone) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurname());
            ps.setString(3, patient.getPhone());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0; // true if at least one row was inserted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

	}

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setPhone(rs.getString("phone"));
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name = ?, surname = ?, phone = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getSurname());
            ps.setString(3, patient.getPhone());
            ps.setInt(4, patient.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}