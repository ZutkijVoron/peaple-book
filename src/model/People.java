package src.model;

import javax.xml.crypto.Data;

public class People {
	private String firstName;
	private String lastName;
	private String secondName;
	private Data birthDate;
	private int phone;
	private char gender;

	public People(String firstName, String lastName, String secondName, Data birthDate, int phone, char gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Data getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Data birthDate) {
		this.birthDate = birthDate;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "{ firstName: " + firstName + ", lastName: " + lastName + ", secondName: " + secondName
				+ ", birthDate: " + birthDate + ", phone: " + phone + ", gender: " + gender + " }";
	}
}
