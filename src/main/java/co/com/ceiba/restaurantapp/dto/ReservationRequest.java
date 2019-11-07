package co.com.ceiba.restaurantapp.dto;

import java.util.Calendar;

public class ReservationRequest {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Calendar reservationDate;
	private boolean decor;
	private int numberPeople;

	public ReservationRequest(int id, String firstName, String lastName, String email, String phoneNumber,
			Calendar reservationDate, boolean decor, int numberPeople, Calendar currentDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.reservationDate = reservationDate;
		this.decor = decor;
		this.numberPeople = numberPeople;
		this.currentDate = currentDate;
	}
	
	public ReservationRequest() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Calendar getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Calendar reservationDate) {
		this.reservationDate = reservationDate;
	}

	public boolean isDecor() {
		return decor;
	}

	public void setDecor(boolean decor) {
		this.decor = decor;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	Calendar currentDate = Calendar.getInstance();

	public Calendar getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Calendar currentDate) {
		this.currentDate = currentDate;
	}

}
