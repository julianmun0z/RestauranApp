package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationTestDataBuilder;
import co.com.ceiba.restaurantapp.dominio.Reservation;


public class ReservationTest {
	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2019,8,24);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = false;
	@Test
	public void createReservationTest() {
		//arrange
		ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
				.whitReservation(RESERVATIONDATE)
				.whiteDecor(DECOR)
				.whitNumberPeople(NUMBERPEOPLE);
		
		//act
		Reservation reservation = reservationTestDataBuilder.build();
		
		//assert
		assertEquals(RESERVATIONDATE, reservation.getReservationDate());
		assertEquals(DECOR, reservation.isDecor());
		assertEquals(NUMBERPEOPLE, reservation.getNumberPeople());
		
	}
}
