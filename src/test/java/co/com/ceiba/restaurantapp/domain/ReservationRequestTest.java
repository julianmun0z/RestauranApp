package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationRequestTestDataBuilder;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;

public class ReservationRequestTest {
	
	

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2019,8,24);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = false; 
	
	
	@Test
	public void createReservationRequestTest() {
		//arrange
		ReservationRequestTestDataBuilder reservationRequestTestDataBuilder = new ReservationRequestTestDataBuilder()
				.whiteFirstName(FIRSTNAME)
				.whiteLastName(LASTNAME)
				.whiteEmail(EMAIL)
				.whitePhoneNumber(PHONENUMBER)
				.whiteReservationDate(RESERVATIONDATE)
				.whiteNumberPeople(NUMBERPEOPLE)
				.whiteDecor(DECOR);
				
		//act
		
		ReservationRequest reservationRequest = reservationRequestTestDataBuilder.build();
		
		//assert
		assertEquals(FIRSTNAME, reservationRequest.getFirstName());
		assertEquals(LASTNAME, reservationRequest.getLastName());
		assertEquals(EMAIL, reservationRequest.getEmail());
		assertEquals(PHONENUMBER, reservationRequest.getPhoneNumber());
		assertEquals(RESERVATIONDATE, reservationRequest.getReservationDate());
		assertEquals(DECOR, reservationRequest.isDecor());
		assertEquals(NUMBERPEOPLE, reservationRequest.getNumberPeople());
	}
}


