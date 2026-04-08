package model.metiers;


import java.util.List;
import dao.DaoPatient;
import model.entities.Patient;

public class ModelPatient {
	private Patient patient = new Patient();
	private List<Patient> Patients;
	private DaoPatient daopatient = new DaoPatient();

	public boolean addPatient() {
		return daopatient.addPatient(patient);	
	}

	public List<Patient> getAllPatients() {
		this.Patients = daopatient.getAllPatients();
		return Patients;
	}

	public Patient getPatientById(int id) {
		this.patient = daopatient.getPatientById(id);
		return patient;
	}

	public boolean updatePatient() {
		return daopatient.updatePatient(patient);
	}

	public boolean deletePatient(int id) {
		return daopatient.deletePatient(id);
	}

	public void setPatient(Patient Patient) {
		this.patient = Patient;
	}

	public Patient getPatient() {
		return patient;
	}

	public List<Patient> getTPatients() {
		return Patients;
	}
}
