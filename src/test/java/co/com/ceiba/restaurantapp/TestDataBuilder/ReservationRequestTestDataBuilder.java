package co.com.ceiba.restaurantapp.TestDataBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.com.ceiba.restaurantapp.dto.ReservationRequest;

public class ReservationRequestTestDataBuilder {

	
	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";
	
	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2029, 02, 02);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;
	

	private String firstName;
	private String lastName;
	private String Email;
	private String phoneNumber;
	
	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;
	
	
	public ReservationRequestTestDataBuilder() {
	
		this.firstName = FIRSTNAME;
		this.lastName = LASTNAME;
		this.Email = EMAIL;
		this.phoneNumber = PHONENUMBER;
		this.reservationDate = RESERVATIONDATE;
		this.numberPeople = NUMBERPEOPLE;
		this.decor = DECOR;
		
	}


	public ReservationRequestTestDataBuilder whiteFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}


	public ReservationRequestTestDataBuilder whiteLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}


	/**
	 * @param email
	 */
	public ReservationRequestTestDataBuilder whiteEmail(String email) {
		Email = email;
		return this;
	}


	/**
	 * @param phoneNumber
	 */
	public ReservationRequestTestDataBuilder whitePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}


	/**
	 * @param reservationDate
	 */
	public ReservationRequestTestDataBuilder whiteReservationDate(Calendar reservationDate) {
		this.reservationDate = reservationDate;
		return this;
	}


	/**
	 * @param numberPeople
	 */
	public ReservationRequestTestDataBuilder whiteNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
		return this;
	}


	/**
	 * @param decor
	 */
	public ReservationRequestTestDataBuilder whiteDecor(boolean decor) {
		this.decor = decor;
		return this;
	}
	
	public ReservationRequest build() {
		return new ReservationRequest(firstName, lastName, Email, phoneNumber, reservationDate, numberPeople, decor);
}
	
	
	
	
}
