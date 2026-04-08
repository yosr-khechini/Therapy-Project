package model.entities;

public class Therapist extends Person {
	private String email;
	private String speciality;
	public Therapist() {}

	public Therapist(int id, String name, String surname, String speciality, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.email = email;
	}

	public Therapist(String name, String surname, String speciality, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
