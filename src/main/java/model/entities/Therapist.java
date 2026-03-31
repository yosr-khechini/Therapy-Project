package model.entities;

public class Therapist {
	private String name;
	private String surname;
	private String speciality;
	private String email;
	
	
	public Therapist(String name, String surname, String speciality, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
