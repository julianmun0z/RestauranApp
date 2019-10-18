package co.com.ceiba.restaurantapp.builderTest;

 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.restaurantapp.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
public class ReservationResquestBuilderTest {

	private static final int NUMBER_PEOPLE = 5;
	private static final int MINUS_NUMBER_PEOPLE = 2;
	private static final float PRICE = 350000;
//	private static final int DISCOUNT_FOR_PEOPLE = 15;
//	private static final int DISCOUNT_FOR_DAYS = 20;
	private static final boolean DECOR = true;
	private static final boolean DECOR_IS_FALSE = false;
	private static final String NAME_FIXED_PRICE= "Julian";
	private static final float FIXED_PRICE = 60000;
	private static final int VALUE_FOR_PERSON = 50000;
	private static final int PERCENT_DAYS = 20;
	private static final int PERCENT_FOR_PEOPLE = 15;
	private static final int DISCOUNT_SPLITTER = 100;
	private static final int FIXED_DECOR = 30000;
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY = new GregorianCalendar(2019, 8, 01);
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY= new GregorianCalendar(2019, 9, 11);
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY=  new GregorianCalendar(2019, 9, 12);
	private static final Calendar DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE= new GregorianCalendar(2019, 9, 11);
	private static final Calendar DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO = new GregorianCalendar(2019, 9, 7);
	private static final Calendar DATE_ONE = new GregorianCalendar(2019 , 9, 8);
	private static final Calendar DATE_TWO = new GregorianCalendar(2019, 9, 9);	
	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";
	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";
	private static final String LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION = "LA RESERVA PARA LOS DIAS VIERNES Y SABADOS DEBEN TENER 15 DIAS DE ANTICIPACION";
	private static final String FIRST_NAME_IS_NULL = "";	
	private static final Calendar DATE_WITH_FRIDAY_AND_SATURDAY = new GregorianCalendar(2019, 8, 16);

	@Mock
	private ReservationRequest reservationRequest;

	@Mock
	private Bill bill;
	@Mock
	private Client client;
	@Mock
	private Reservation reservation;
	
	@InjectMocks
	private ReservationResquestBuilder reservationResquestBuilder;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		reservationResquestBuilder = new ReservationResquestBuilder();
		
	}
	
	/*
	 * por corregir
	 */
	@Test
	public void daysWithRestrictioniSMoreGreaterThanFifteenDays() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newDaysWithRestriction = 60000;
		float price = 60000;
	
		//act
		float expectanDaysWithRestriction = reservationResquestBuilder.daysWithRestriction(reservationRequest, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	@Test
	public void daysWithRestrictioniSZeroSaturday() {
		//arrange
		
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO);

		float newDaysWithRestriction = 0;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = reservationResquestBuilder.daysWithRestriction(reservationRequest, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	@Test
	public void daysWithRestrictioniSZeroFriday() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE);

		//reservationRequest.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY);
		float newDaysWithRestriction = 0;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = reservationResquestBuilder.daysWithRestriction(reservationRequest, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	


	
	@Test
	public void daysWithRestriction() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		//reservationRequest.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newDaysWithRestriction = 60000;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = reservationResquestBuilder.daysWithRestriction(reservationRequest, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	@Test
	public void getDiscuntForSpecialDaysWednesdayTest() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_TWO);
		reservationRequest.setReservationDate(DATE_TWO);
		float newGetDiscuntForSpecialDays = 12000;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = reservationResquestBuilder.getDiscuntForSpecialDays(reservationRequest, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	
	@Test
	public void getDiscuntForSpecialDaysTuesdayTest() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_ONE);
		reservationRequest.setReservationDate(DATE_ONE);
		float newGetDiscuntForSpecialDays = 12000;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = reservationResquestBuilder.getDiscuntForSpecialDays(reservationRequest, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	@Test
	public void getDiscuntForSpecialDaysTestIsZero() {
		//arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		reservationRequest.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newGetDiscuntForSpecialDays = 0;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = reservationResquestBuilder.getDiscuntForSpecialDays(reservationRequest, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	@Test
	public void getNotDiscuontPerPeopleTest() {
		//arrange
		bill.setPrice(PRICE);
		reservationRequest.setNumberPeople(MINUS_NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = 0;
		float price = 50000;
		//act
		
		float expectangetDiscuontPerPeople = reservationResquestBuilder.getDiscuontPerPeople(reservationRequest, price);
		
		//assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople,0);
	}

	@Test
	public void getDiscuontPerPeopleTest() {
		//arrange
		when(bill.getPrice()).thenReturn(PRICE);
		bill.setPrice(PRICE);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		reservationRequest.setNumberPeople(NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = 7500;
		float price = 50000;
		//act
		
		float expectangetDiscuontPerPeople = reservationResquestBuilder.getDiscuontPerPeople(reservationRequest, price);
		
		//assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople,0);
	}
	
	@Test
	public void getExtraPersonTest() {
		// arrange
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		//reservationRequest.setNumberPeople(NUMBER_PEOPLE);
		float newExtraPerson = 250000;
		// act
		float expectanExtraPersona = reservationResquestBuilder.getExtraPerson(reservationRequest);

		// assert
		assertEquals(newExtraPerson, expectanExtraPersona, 0);
	}

	@Test
	public void setFixedPriceTest() {
		// arrange
		when(reservationRequest.getFirstName()).thenReturn(NAME_FIXED_PRICE);
		when(bill.getPrice()).thenReturn(FIXED_PRICE);
		float newSetFixedPrice = 60000;
		// act
		float expectanSetFixedPrice = reservationResquestBuilder.giveValueToThePrice(reservationRequest);

		// assert
		assertEquals(newSetFixedPrice, expectanSetFixedPrice, 0);
	}
	
	@Test
	public void setFixedPriceValueZeroTest() {
		// arrange
		reservationRequest.getFirstName();
		bill.setPrice(FIXED_PRICE);
		float newSetFixedPrice = 0;
		// act
		float expectanSetFixedPrice = reservationResquestBuilder.giveValueToThePrice(reservationRequest);

		// assert
		assertEquals(newSetFixedPrice, expectanSetFixedPrice, 0);
	}
	
	@Test
	public void FixedDecorFalseTest() {
		// arrange
		reservationRequest.setDecor(DECOR_IS_FALSE);
		float newFixedDecor = 0;

		// act
		float expectantFixedDecor = reservationResquestBuilder.fixedDecor(reservationRequest);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, 0);

	}
	
	@Test
	public void FixedDecorTest() {
		// arrange
		when(reservationRequest.isDecor()).thenReturn(DECOR);
		float newFixedDecor = 30000;

		// act
		float expectantFixedDecor = reservationResquestBuilder.fixedDecor(reservationRequest);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, 0);

	}
	
	@Test
	public void TestForLessThanFifteenDays() { 

		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO);
		long newDifferenceDays = 4;
		// act
		long newDiferens = reservationResquestBuilder.differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		// assert
		assertEquals(newDifferenceDays, newDiferens);

	}

	@Test
	public void differenceBetweenCurrentDateAndReservationDateTest() {

		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_FRIDAY_AND_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);		
		long newDifferenceDays = 15;
		// act
		long newDiferens = reservationResquestBuilder.differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		// assert
		assertEquals(newDifferenceDays, newDiferens);

	}
	
	@Test
	public void firstNameFieldValidationIsValueNullTest ( ) {
		//arrange
		when(reservationRequest.getFirstName()).thenReturn(null);
		reservationRequest.setFirstName(null);
		 String newMenssageForNull =  EL_NOMBRE_ES_OBLIGATORIO;
		  String otro="";
		//act
		 try {
			 reservationResquestBuilder.firstNameFieldValidation(reservationRequest);
			}
			catch(Exception e) {
			  otro=e.getMessage();
			}
		
		
		
		 //assert
		assertEquals(newMenssageForNull, otro);
	
	}



}

