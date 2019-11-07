package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.restaurantapp.TestDataBuilder.BillTestbuilder;
import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.services.ReservationRequestService;

public class BillTest {

	private static final int NUMBER_PEOPLE = 5;
	private static final int MINUS_NUMBER_PEOPLE = 2;

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private static final boolean DECOR = true;
	private static final boolean DECOR_IS_FALSE = false;
	private static final String NAME_FIXED_PRICE = "Julian";
	private static final float FIXED_PRICE = 60000;
	private static final float NEW_PRICE = 60000;
	private static final float EXPECTED_PRICE_ZERO = 0;
	private static final float NEW_GET_DISCOUNT_FOR_SPECIAL_DAYS = 12000;
	private static final float DISCOUNT_PER_PEOPLE_ZERO = 0;
	private static final float DISCOUNT_PER_PEOPLE_FOR_VALUE = 7500;
	private static final float PRICE_WHITE_DISCOUNT = 50000;

	private static final int EXPECTED_DISCOUNT_FOR_PEOPLE = 36120;
	private static final int EXPECTED_DISCOUNT_FOR_DAYS = 48160;
	private static final float PRICE_FOR_PERSON = 250000;
	private static final float DISCOUNT_PER_PEOPLE = 52500;
	private static final float FIXED_VALUE_DECOR = 30000;
	private static final int DISCOUNT_FOR_DAYS_TUESDAY_AND_WEDNESDAY = 70000;
	private static final float VALUE_DAY_WITH_RESTRICTION = 350000;
	private static final long NUMBER_OF_DAYS_INSUFFICIENT = 4;
	private static final long NUMBER_OF_DAYS_REQUIRED = 15;

	private static final int DELTA = 0;

	private static final Calendar DATE_WITH_TUESDAY = new GregorianCalendar(2019, 8, 03);
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY = new GregorianCalendar(2019, 8, 01);
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY = new GregorianCalendar(2019,
			9, 11);
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY = new GregorianCalendar(
			2019, 9, 12);
	private static final Calendar DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE = new GregorianCalendar(2019, 9, 11);
	private static final Calendar DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO = new GregorianCalendar(2019, 9, 7);
	private static final Calendar DATE_ONE = new GregorianCalendar(2019, 9, 8);
	private static final Calendar DATE_TWO = new GregorianCalendar(2019, 9, 9);

	private static final Calendar DATE_WITH_FRIDAY_AND_SATURDAY = new GregorianCalendar(2019, 8, 16);

	@Mock
	private ReservationRequest reservationRequest;

	@Mock
	private Bill bill;

	@Mock
	private Client client;
	@Mock
	private Reservation reservation;
	@Mock
	private ReservationRequestService reservationRequestService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		bill = new Bill(0, 0, 0);
	}

	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;

	@Test
	public void createBillTest() {

		// arrange
		BillTestbuilder billTestbuilder = new BillTestbuilder().whitePrice(PRICE)
				.whiteDiscountForPeople(DISCOUNTFORPEOPLE).whiteDiscountForDays(DISCOUNTFORDAYS);

		// act
		Bill bill = billTestbuilder.build();

		// assert

		assertEquals(PRICE, bill.getPrice(), DELTA);
		assertEquals(DISCOUNTFORPEOPLE, bill.getDiscountForPeople());
		assertEquals(DISCOUNTFORDAYS, bill.getDiscpuntForDays());
	}

	@Test
	public void getCaculatePriceAndDiscountsTest() {
		// arrange
		when(reservationRequest.getFirstName()).thenReturn(FIRSTNAME);
		when(reservationRequest.getLastName()).thenReturn(LASTNAME);
		when(reservationRequest.getEmail()).thenReturn(EMAIL);
		when(reservationRequest.getPhoneNumber()).thenReturn(PHONENUMBER);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationRequest.isDecor()).thenReturn(DECOR);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);

		float expectedPrice = NEW_PRICE;
		float expectedPriceForPerson = PRICE_FOR_PERSON;
		float expectedDiscuontPerPeople = DISCOUNT_PER_PEOPLE;
		float expectedFixedValueDecor = FIXED_VALUE_DECOR;
		int expectedDiscountForDaysTuesdayAndWednesday = DISCOUNT_FOR_DAYS_TUESDAY_AND_WEDNESDAY;
		float expectedDaysWithRestriction = VALUE_DAY_WITH_RESTRICTION;
		int expectedDiscountForPeople = EXPECTED_DISCOUNT_FOR_PEOPLE;
		int expectedDiscounForDays = EXPECTED_DISCOUNT_FOR_DAYS;
		float price = PRICE;

		// act
		float resultValueToThePrice = bill.giveValueToThePrice(reservationRequest);
		float ValueForPerson = bill.getValueForPerson(reservationRequest);
		float resultDiscuontPerPeople = bill.getDiscuontPerPeople(reservationRequest, price);
		float resultDiscountForDaysTuesdayAndWednesday = bill.getDiscountForDaysTuesdayAndWednesday(reservationRequest,
				price);
		float resultFixedValueDecor = bill.getFixedValueDecor(reservationRequest);
		float resultDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		Bill result = bill.getCaculatePriceAndDiscounts(reservationRequest, bill);

		// assert
		assertEquals(expectedDaysWithRestriction, resultDaysWithRestriction, DELTA);
		assertEquals(expectedPrice, resultValueToThePrice, DELTA);
		assertEquals(expectedPriceForPerson, ValueForPerson, DELTA);
		assertEquals(expectedDiscuontPerPeople, resultDiscuontPerPeople, DELTA);
		assertEquals(expectedDiscountForDaysTuesdayAndWednesday, resultDiscountForDaysTuesdayAndWednesday, DELTA);
		assertEquals(expectedFixedValueDecor, resultFixedValueDecor, DELTA);
		assertEquals(expectedDiscountForPeople, result.getDiscountForPeople(), DELTA);
		assertEquals(expectedDiscounForDays, result.getDiscpuntForDays(), DELTA);
	}

	@Test
	public void getCaculatePriceAndDiscountsTestXXX() {
		// arrange
		when(reservationRequest.getFirstName()).thenReturn(FIRSTNAME);
		when(reservationRequest.getLastName()).thenReturn(LASTNAME);
		when(reservationRequest.getEmail()).thenReturn(EMAIL);
		when(reservationRequest.getPhoneNumber()).thenReturn(PHONENUMBER);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationRequest.isDecor()).thenReturn(DECOR);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationRequest.getReservationDate())
				.thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY);
		float expectedDaysWithRestriction = EXPECTED_PRICE_ZERO;
		float price = PRICE;
		String messageResult = "";
		String newMenssagerForNull = "LA RESERVA PARA LOS DIAS VIERNES Y SABADOS DEBEN TENER 15 DIAS DE ANTICIPACION";
		
		// act
		float resultDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		try {
			bill.getCaculatePriceAndDiscounts(reservationRequest, bill);
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		
		// assert
		assertEquals(newMenssagerForNull, messageResult);
		assertEquals(expectedDaysWithRestriction, resultDaysWithRestriction, DELTA);
	}

	@Test
	public void daysWithRestrictioniSMoreGreaterThanFifteenDays() {
		
		// arrange
		when(reservationRequest.getReservationDate())
				.thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newDaysWithRestriction = FIXED_PRICE;
		float price = NEW_PRICE;

		// act
		float expectanDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		
		// assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction, DELTA);
	}

	@Test
	public void daysWithRestrictioniSZeroSaturday() {
		// arrange
		when(reservationRequest.getReservationDate())
				.thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO);

		float newDaysWithRestriction = EXPECTED_PRICE_ZERO;
		float price = NEW_PRICE;
		// act
		float expectanDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		// assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction, DELTA);
	}

	@Test
	public void daysWithRestrictioniSZeroFriday() {
		// arrange
		when(reservationRequest.getReservationDate())
				.thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE);
		float newDaysWithRestriction = EXPECTED_PRICE_ZERO;
		float price = NEW_PRICE;
		// act
		float expectanDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		// assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction, DELTA);
	}

	@Test
	public void daysWithRestriction() {
		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_ONE);
		float newDaysWithRestriction = FIXED_PRICE;
		float price = NEW_PRICE;
		// act
		float expectanDaysWithRestriction = bill.daysWithRestriction(reservationRequest, price);
		// assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction, DELTA);
	}

	@Test
	public void getDiscuntForSpecialDaysWednesdayTest() {
		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_TWO);
		float newGetDiscuntForSpecialDays = NEW_GET_DISCOUNT_FOR_SPECIAL_DAYS;
		float price = NEW_PRICE;
		// act
		float expectangetDiscuntForSpecialDays = bill.getDiscountForDaysTuesdayAndWednesday(reservationRequest, price);

		// assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays, DELTA);
	}

	@Test
	public void getDiscuntForSpecialDaysTuesdayTest() {
		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_ONE);
		float newGetDiscuntForSpecialDays = NEW_GET_DISCOUNT_FOR_SPECIAL_DAYS;
		float price = NEW_PRICE;
		// act
		float expectangetDiscuntForSpecialDays = bill.getDiscountForDaysTuesdayAndWednesday(reservationRequest, price);

		// assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays, DELTA);
	}

	@Test
	public void getDiscuntForSpecialDaysTestIsZero() {
		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newGetDiscuntForSpecialDays = EXPECTED_PRICE_ZERO;
		float price = NEW_GET_DISCOUNT_FOR_SPECIAL_DAYS;
		// act
		float expectangetDiscuntForSpecialDays = bill.getDiscountForDaysTuesdayAndWednesday(reservationRequest, price);

		// assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays, DELTA);
	}

	@Test
	public void getNotDiscuontPerPeopleTest() {
		// arrange
		bill.setPrice(PRICE);
		reservationRequest.setNumberPeople(MINUS_NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = DISCOUNT_PER_PEOPLE_ZERO;
		float price = PRICE_WHITE_DISCOUNT;
		// act

		float expectangetDiscuontPerPeople = bill.getDiscuontPerPeople(reservationRequest, price);

		// assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople, DELTA);
	}

	@Test
	public void getDiscuontPerPeopleTest() {
		// arrange
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = DISCOUNT_PER_PEOPLE_FOR_VALUE;
		float price = PRICE_WHITE_DISCOUNT;
		// act

		float expectangetDiscuontPerPeople = bill.getDiscuontPerPeople(reservationRequest, price);

		// assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople, DELTA);
	}

	@Test
	public void getExtraPersonTest() {
		// arrange
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		float newExtraPerson = PRICE_FOR_PERSON;
		// act
		float expectanExtraPersona = bill.getValueForPerson(reservationRequest);

		// assert
		assertEquals(newExtraPerson, expectanExtraPersona, DELTA);
	}

	@Test
	public void setFixedPriceTest() {
		// arrange
		when(reservationRequest.getFirstName()).thenReturn(NAME_FIXED_PRICE);
		float newSetFixedPrice = FIXED_PRICE;
		// act
		float expectanSetFixedPrice = bill.giveValueToThePrice(reservationRequest);

		// assert
		assertEquals(newSetFixedPrice, expectanSetFixedPrice, DELTA);
	}

	@Test
	public void setFixedPriceValueZeroTest() {
		// arrange
		reservationRequest.getFirstName();
		bill.setPrice(FIXED_PRICE);
		float newSetFixedPrice = EXPECTED_PRICE_ZERO;
		// act
		float expectanSetFixedPrice = bill.giveValueToThePrice(reservationRequest);

		// assert
		assertEquals(newSetFixedPrice, expectanSetFixedPrice, DELTA);
	}

	@Test
	public void FixedDecorFalseTest() {
		// arrange
		reservationRequest.setDecor(DECOR_IS_FALSE);
		float newFixedDecor = EXPECTED_PRICE_ZERO;

		// act
		float expectantFixedDecor = bill.getFixedValueDecor(reservationRequest);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, DELTA);

	}

	@Test
	public void getFixedValueDecorTest() {
		// arrange
		when(reservationRequest.isDecor()).thenReturn(DECOR);
		float newFixedDecor = FIXED_VALUE_DECOR;

		// act
		float expectantFixedDecor = bill.getFixedValueDecor(reservationRequest);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, DELTA);

	}

	@Test
	public void TestForLessThanFifteenDays() {

		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO);
		long expectadDifferenceDays = NUMBER_OF_DAYS_INSUFFICIENT;
		// act
		long DifferenceDays = bill.differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		// assert
		assertEquals(expectadDifferenceDays, DifferenceDays);

	}

	@Test
	public void differenceBetweenCurrentDateAndReservationDateTest() {

		// arrange
		when(reservationRequest.getReservationDate()).thenReturn(DATE_WITH_FRIDAY_AND_SATURDAY);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		long expectadDifferenceDays = NUMBER_OF_DAYS_REQUIRED;
		// act
		long DifferenceDays = bill.differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		// assert
		assertEquals(expectadDifferenceDays, DifferenceDays);

	}

}
