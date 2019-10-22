package co.com.ceiba.restaurantapp.builderTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;

public class ClientBuilderTest {

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private static final Boolean DECOR = true;
	private static final int NUMBER_PEOPLE = 5;
	private static final Calendar DATE_FOR_DIVISION_DTO = new GregorianCalendar(2019, 9, 12);

	private static final int DISCOUNT_FOR_PEOPLE = 5000;
	private static final int DISCOUNT_FOR_DAY = 6000;
	private static final float PRICE = 350000;
	private static final float EXPECTED_PRICE = 350000;

	@Mock
	private Client client;

	@Mock
	private ClientEntity clientEntity;

	@Mock
	private ClientBuilder clientBuilder;

	@InjectMocks
	private ClientBuilderTest clientBuilderTest;

	@Mock
	private Reservation reservation;

	@Mock
	private ReservationEntity reservationEntity;

	@Mock
	private Bill bill;

	@Mock
	private BillEntity billEntity;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		clientBuilder = new ClientBuilder();
	}

	@Test
	public void convertClientToClientEntity() {
		//arrange
		when(client.getClientId()).thenReturn(2);
		when(client.getReservation()).thenReturn(reservation);
		when(client.getFirstName()).thenReturn(FIRSTNAME);
		when(client.getLastName()).thenReturn(LASTNAME);
		when(client.getEmail()).thenReturn(EMAIL);
		when(client.getPhoneNumber()).thenReturn(PHONENUMBER);
		when(reservation.getReservationDate()).thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservation.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservation.isDecor()).thenReturn(DECOR);
		when(reservation.getBill()).thenReturn(bill);
		
		when(bill.getPrice()).thenReturn(PRICE);
		when(bill.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(bill.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);

		int expectedClientId = 2;
		String expectedFirstname = FIRSTNAME;
		String expectedFiLastName = LASTNAME;
		String expectedEmail = EMAIL;
		String expectedPhoneNumber = PHONENUMBER;
		Calendar expectedReservationDay = DATE_FOR_DIVISION_DTO;

		
		//act
		
		ClientEntity resultClientEntity = clientBuilder.convertClientToRClientEntity(client);
		
		//assert
		assertEquals(expectedClientId, resultClientEntity.getClientId(),0);
		assertEquals(expectedFirstname, resultClientEntity.getFirstName());
		assertEquals(expectedFiLastName, resultClientEntity.getLastName());
		assertEquals(expectedEmail, resultClientEntity.getEmail());
		assertEquals(expectedPhoneNumber, resultClientEntity.getPhoneNumber());
		assertEquals(expectedReservationDay, resultClientEntity.getReservationEntity().getReservationDate());
		}
	
	@Test
	public void convertClientEntityToClient() {
		//arrange
		when(clientEntity.getClientId()).thenReturn(2);
		when(clientEntity.getReservationEntity()).thenReturn(reservationEntity);
		when(clientEntity.getFirstName()).thenReturn(FIRSTNAME);
		when(clientEntity.getLastName()).thenReturn(LASTNAME);
		when(clientEntity.getEmail()).thenReturn(EMAIL);
		when(clientEntity.getPhoneNumber()).thenReturn(PHONENUMBER);
		when(clientEntity.getReservationEntity().getIdReservation()).thenReturn(4);
		when(reservationEntity.getReservationDate()).thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservationEntity.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationEntity.isDecor()).thenReturn(DECOR);
		when(reservationEntity.getBillEntity()).thenReturn(billEntity);
		when(reservationEntity.getBillEntity().getBillId()).thenReturn(4);
		when(billEntity.getPrice()).thenReturn(PRICE);
		when(billEntity.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(billEntity.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);
		when(reservation.getReservationDate()).thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservation.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservation.isDecor()).thenReturn(DECOR);
		when(reservation.getBill()).thenReturn(bill);
		when(bill.getPrice()).thenReturn(PRICE);
		when(bill.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(bill.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);

		int expectedClientId = 2;
		String expectedFirstname = FIRSTNAME;
		String expectedFiLastName = LASTNAME;
		String expectedEmail = EMAIL;
		String expectedPhoneNumber = PHONENUMBER;
		Calendar expectedReservationDay = DATE_FOR_DIVISION_DTO;
		
		//act
		Client resultClient = clientBuilder.convertClientEntityToClient(clientEntity);
		
		//assert
		assertEquals(expectedClientId, resultClient.getClientId(),0);

		assertEquals(expectedFirstname, resultClient.getFirstName());
		assertEquals(expectedFiLastName, resultClient.getLastName());
		assertEquals(expectedEmail, resultClient.getEmail());
		assertEquals(expectedPhoneNumber, resultClient.getPhoneNumber());
		assertEquals(expectedReservationDay, resultClient.getReservation().getReservationDate());
	}

}
