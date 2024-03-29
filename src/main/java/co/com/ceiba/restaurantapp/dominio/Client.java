package co.com.ceiba.restaurantapp.dominio;

import co.com.ceiba.restaurantapp.dominio.strategies.ArgumentsValidator;

public class Client {

	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";

	private Integer clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Reservation reservation;

	public Client(Integer clientId, String firstName, String lastName, String email, String phoneNumber,
			Reservation reservation) {

		ArgumentsValidator.restrictionForNull(firstName, EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(firstName, EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(lastName, EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(lastName, EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(email, EL_EMAIL_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(email, EL_EMAIL_ES_OBLIGATORIO);

		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.reservation = reservation;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Reservation getReservation() {
		return reservation;
	}

}
