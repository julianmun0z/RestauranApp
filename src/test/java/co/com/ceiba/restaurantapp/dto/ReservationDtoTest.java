package co.com.ceiba.restaurantapp.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import co.com.ceiba.restaurantapp.dominio.ReservationDto;
import co.com.ceiba.restaurantapp.testdatabuilder.ReservationDtoTestDataBuilder;



public class ReservationDtoTest {
	@Deprecated
	private static final Date RESERVATIONDATE = new Date(2019-1900,8,24);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = false;
	@Test
	public void createReservationTest() {
		//arrange
		ReservationDtoTestDataBuilder reservationTestDataBuilder = new ReservationDtoTestDataBuilder()
				.whitReservation(RESERVATIONDATE)
				.whiteDecor(DECOR)
				.whitNumberPeople(NUMBERPEOPLE);
		
		//act
		ReservationDto reservation = reservationTestDataBuilder.buil();
		
		//assert
		assertEquals(RESERVATIONDATE, reservation.getReservationDate());
		assertEquals(DECOR, reservation.isDecor());
		assertEquals(NUMBERPEOPLE, reservation.getNumberPeople());
		
	}
}
