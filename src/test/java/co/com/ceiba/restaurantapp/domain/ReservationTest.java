package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationTestDataBuilder;
import co.com.ceiba.restaurantapp.dominio.Reservation;


public class ReservationTest {
	
	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2019,8,24);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = false;
	
	private static final Calendar RESERVATIONDATE_NULL = null;
	private static final int NUMBERPEOPLE_ZERO = 0;
	
	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";

	
	
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
	
	@Test
	public void validationReservationDateTest() {
		//arrange
		ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
				.whitReservation(RESERVATIONDATE_NULL);
		String expectedMessage = LA_FECHA_ES_OBLIGATORIA;
		String messageResult = "";
		
		//act
		try {
			reservationTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		
		//assert
		assertEquals(expectedMessage,messageResult);		
	}
	
	@Test
	public void validationNumberPeopleTest() {
		//arrange
		ReservationTestDataBuilder reservationTestDataBuilder = new ReservationTestDataBuilder()
				.whitReservation(RESERVATIONDATE)
				.whitNumberPeople(NUMBERPEOPLE_ZERO);
		String expectedMessage = EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO;
		String messageResult = "";
		
		//act
		try {
			reservationTestDataBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		
		//assert
		assertEquals(expectedMessage,messageResult);		
	}
}
 