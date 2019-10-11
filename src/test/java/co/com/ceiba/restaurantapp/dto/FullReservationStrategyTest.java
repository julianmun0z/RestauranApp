package co.com.ceiba.restaurantapp.dto;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.restaurantapp.dominio.FullReservationDto;
import co.com.ceiba.restaurantapp.dominio.strategies.FullReservationStrategy;


@Deprecated
public class FullReservationStrategyTest {

	private static final int NUMBER_PEOPLE = 5;
	private static final int MINUS_NUMBER_PEOPLE = 2;
	private static final float PRICE = 350000;
	private static final boolean DECOR = true;
	private static final boolean DECOR_IS_FALSE = false;
	private static final float FIXED_PRICE = 60000;
	private static final Date DATE_WITH_TUESDAY_AND_WENESDAY = new Date(2019 - 1900, 8, 01);
	private static final Date DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY= new Date(2019 - 1900, 9, 10);
	private static final Date DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY= new Date(2019 - 1900, 9, 11);
	private static final Date DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE= new Date(2019 - 1900, 9, 11);
	private static final Date DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO = new Date(2019 - 1900, 9, 7);
	private static final Date DATE_ONE = new Date(2019 - 1900, 9, 8);
	private static final Date DATE_TWO = new Date(2019 - 1900, 9, 9);

	

	
	
	private static final Date DATE_WITH_FRIDAY_AND_SATURDAY = new Date(2019 - 1900, 8, 16);

	@InjectMocks
	private FullReservationDto fullReservationDto = new FullReservationDto();

	@InjectMocks
	private FullReservationStrategy fullReservationStrategy;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void daysWithRestrictioniSMoreGreaterThanFifteenDays() {
		//arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		float newDaysWithRestriction = 0;
		float price = 60000;
	
		//act
		float expectanDaysWithRestriction = fullReservationStrategy.daysWithRestriction(fullReservationDto, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	 
	@Test
	public void daysWithRestrictioniSZeroSaturday() {
		//arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_SATURDAY);
		float newDaysWithRestriction = 0;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = fullReservationStrategy.daysWithRestriction(fullReservationDto, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	@Test
	public void daysWithRestrictioniSZeroFriday() {
		//arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY_FOR_ZERO_TEST_FOR_FRIDAY);
		float newDaysWithRestriction = 0;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = fullReservationStrategy.daysWithRestriction(fullReservationDto, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	


	
	@Test
	public void daysWithRestriction() {
		//arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newDaysWithRestriction = 60000;
		float price = 60000;
		//act
		float expectanDaysWithRestriction = fullReservationStrategy.daysWithRestriction(fullReservationDto, price);
		//assert
		assertEquals(newDaysWithRestriction, expectanDaysWithRestriction,0);
	}
	
	@Test
	public void getDiscuntForSpecialDaysWednesdayTest() {
		//arrange
		fullReservationDto.setReservationDate(DATE_TWO);
		float newGetDiscuntForSpecialDays = 12000;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = fullReservationStrategy.getDiscuntForSpecialDays(fullReservationDto, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	
	@Test
	public void getDiscuntForSpecialDaysTuesdayTest() {
		//arrange
		fullReservationDto.setReservationDate(DATE_ONE);
		float newGetDiscuntForSpecialDays = 12000;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = fullReservationStrategy.getDiscuntForSpecialDays(fullReservationDto, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	@Test
	public void getDiscuntForSpecialDaysTestIsZero() {
		//arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY);
		float newGetDiscuntForSpecialDays = 0;
		float price = 60000;
		//act
		float expectangetDiscuntForSpecialDays = fullReservationStrategy.getDiscuntForSpecialDays(fullReservationDto, price); 
		
		//assert
		assertEquals(newGetDiscuntForSpecialDays, expectangetDiscuntForSpecialDays,0);
	}
	
	@Test
	public void getNotDiscuontPerPeopleTest() {
		//arrange
		fullReservationDto.setPrice(PRICE);
		fullReservationDto.setNumberPeople(MINUS_NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = 0;
		float price = 50000;
		//act
		
		float expectangetDiscuontPerPeople = fullReservationStrategy.getDiscuontPerPeople(fullReservationDto, price);
		
		//assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople,0);
	}

	@Test
	public void getDiscuontPerPeopleTest() {
		//arrange
		fullReservationDto.setPrice(PRICE);
		fullReservationDto.setNumberPeople(NUMBER_PEOPLE);
		float newgetDiscuontPerPeople = 7500;
		float price = 50000;
		//act
		
		float expectangetDiscuontPerPeople = fullReservationStrategy.getDiscuontPerPeople(fullReservationDto, price);
		
		//assert
		assertEquals(newgetDiscuontPerPeople, expectangetDiscuontPerPeople,0);
	}
	
	
	
	@Test
	public void getExtraPersonTest() {
		// arrange
		fullReservationDto.setNumberPeople(NUMBER_PEOPLE);
		float newExtraPerson = 250000;
		// act
		float expectanExtraPersona = fullReservationStrategy.getExtraPerson(fullReservationDto);

		// assert
		assertEquals(newExtraPerson, expectanExtraPersona, 0);
	}

	@Test
	public void setFixedPriceTest() {
		// arrange
		fullReservationDto.setPrice(FIXED_PRICE);
		float newSetFixedPrice = 60000;
		// act
		float expectanSetFixedPrice = fullReservationStrategy.setFixedPrice(fullReservationDto);

		// assert
		assertEquals(newSetFixedPrice, expectanSetFixedPrice, 0);
	}

	
	
	@Test
	public void FixedDecorFalseTest() {
		// arrange
		fullReservationDto.setDecor(DECOR_IS_FALSE);
		float newFixedDecor = 0;

		// act
		float expectantFixedDecor = fullReservationStrategy.FixedDecor(fullReservationDto);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, 0);

	}
	@Test
	public void FixedDecorTest() {
		// arrange
		fullReservationDto.setDecor(DECOR);
		float newFixedDecor = 30000;

		// act
		float expectantFixedDecor = fullReservationStrategy.FixedDecor(fullReservationDto);

		// assert

		assertEquals(newFixedDecor, expectantFixedDecor, 0);

	}
	
	@Test
	public void TestForLessThanFifteenDays() { 

		// arrange
		fullReservationDto.setReservationDate(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_ONE);
		fullReservationDto.setConcurenDate(DATE_TO_PROVE_DIFFERENCE_BETWEEN_DAYS_TWO);

		long newDifferenceDays = 4;
		// act
		long newDiferens = fullReservationStrategy.differenceBetweenCurrentDateAndReservationDate(fullReservationDto);
		// assert
		assertEquals(newDifferenceDays, newDiferens);

	}

	@Test
	public void differenceBetweenCurrentDateAndReservationDateTest() {

		// arrange
		fullReservationDto.setReservationDate(DATE_WITH_TUESDAY_AND_WENESDAY);
		fullReservationDto.setConcurenDate(DATE_WITH_FRIDAY_AND_SATURDAY);

		long newDifferenceDays = -15;
		// act
		long newDiferens = fullReservationStrategy.differenceBetweenCurrentDateAndReservationDate(fullReservationDto);
		// assert
		assertEquals(newDifferenceDays, newDiferens);

	}
//	@Test
//	public void validationsTest ( ) {
//		//arrange
//		fullReservationDto.setFirstName("");
//		String newMenssageForNull = EL_NOMBRE_ES_OBLIGATORIO;
//		//act
//	void expectanMnesaggeForNull= ArgumentsValidator.restrictionForNull(fullReservationDto.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
//	//assert
//		assertEquals(newMenssageForNull, expectanMnesaggeForNull);
//	
//	}

}
