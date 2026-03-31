package model.metiers;

import java.sql.SQLException;

import dao.DaoTherapist;
import model.entities.Therapist;

public class ModelTherapist {
	private Therapist therapist;
	private DaoTherapist daotherapist = new DaoTherapist();
	public boolean addTherapist() throws SQLException {
		return daotherapist.addTherapist(therapist);	
	}
	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
		
	}
	public Therapist Therapist() {
		return therapist;
	}
}
