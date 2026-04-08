package model.metiers;


import java.util.List;
import dao.DaoTherapist;
import model.entities.Therapist;

public class ModelTherapist {
	private Therapist therapist = new Therapist();
	private List<Therapist> therapists;
	private DaoTherapist daotherapist = new DaoTherapist();

	public boolean addTherapist() {
		return daotherapist.addTherapist(therapist);	
	}

	public List<Therapist> getAllTherapists() {
		this.therapists = daotherapist.getAllTherapists();
		return therapists;
	}

	public Therapist getTherapistById(int id) {
		this.therapist = daotherapist.getTherapistById(id);
		return therapist;
	}

	public boolean updateTherapist() {
		return daotherapist.updateTherapist(therapist);
	}

	public boolean deleteTherapist(int id) {
		return daotherapist.deleteTherapist(id);
	}

	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
	}

	public Therapist getTherapist() {
		return therapist;
	}

	public List<Therapist> getTherapists() {
		return therapists;
	}
}
