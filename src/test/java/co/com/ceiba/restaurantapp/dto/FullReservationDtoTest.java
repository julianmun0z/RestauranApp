package co.com.ceiba.restaurantapp.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;

import co.com.ceiba.restaurantapp.dominio.FullReservationDto;
import co.com.ceiba.restaurantapp.testdatabuilder.FullReservationDtoTestDataBuilder;
import static org.junit.Assert.assertEquals;
public class FullReservationDtoTest {
	
	private static final int BILL_ID = 1;
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";
	
	private static final Date RESERVATIONDATE = new Date(02-02-2019);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;

	
	@InjectMocks
	private FullReservationDto fullReservationDto = new FullReservationDto();

	@Test
	public void createFullReservationTest() {
	

	//arrange
	FullReservationDtoTestDataBuilder fullReservationDtoTestDataBuilder = new FullReservationDtoTestDataBuilder()
			.whitFirstName(FIRSTNAME)
			.whitLastName(LASTNAME)
			.whiteEmail(EMAIL)
			.whitePhoneNumber(PHONENUMBER)
			.whitReservation(RESERVATIONDATE)
			.whitNumberPeople(NUMBERPEOPLE)
			.whiteDecor(DECOR)
			.whiteBillid(BILL_ID)
			.whitePrice(PRICE)
			.whiteDiscountForPeople(DISCOUNTFORPEOPLE)
			.whiteDiscountForDays(DISCOUNTFORDAYS);
	
	//act
	FullReservationDto fullReservationDto = fullReservationDtoTestDataBuilder.build();
	
	//assert
	assertEquals(FIRSTNAME, fullReservationDto.getFirstName());
	assertEquals(LASTNAME, fullReservationDto.getLastName());
	assertEquals(EMAIL, fullReservationDto.getEmail());
	assertEquals(PHONENUMBER, fullReservationDto.getPhoneNumber());
	assertEquals(RESERVATIONDATE, fullReservationDto.getReservationDate());
	assertEquals(NUMBERPEOPLE, fullReservationDto.getNumberPeople());
	assertEquals(DECOR, fullReservationDto.isDecor());
	assertEquals(BILL_ID, fullReservationDto.getId(),0);
	assertEquals(PRICE, fullReservationDto.getPrice(),0);
	assertEquals(DISCOUNTFORPEOPLE, fullReservationDto.getDiscountForPeople());
	assertEquals(DISCOUNTFORDAYS, fullReservationDto.getDiscpuntForDays());
	}
			
}
