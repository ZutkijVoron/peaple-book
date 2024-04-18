package src.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class People {
	private String surname;
	private String firstName;
	private String patronymic;
	private Date birthDate;
	private int phone;
	private char gender;

	public People(String surname, String firstName, String patronymic, Date birthDate, int phone, char gender) {
		super();
		this.surname = surname;
		this.firstName = firstName;
		this.patronymic = patronymic;
		this.birthDate = birthDate;
		this.phone = phone;
		this.gender = gender;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public Date getBirthDate() {
		return (Date) birthDate;
	}

	public int getPhone() {
		return phone;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return "{ surname: " + surname + ", firstName: " + firstName + ", patronymic: " + patronymic
				+ ", birthDate: " + dateFormat.format(birthDate) + ", phone: " + phone + ", gender: " + gender + " }";
	}
}
