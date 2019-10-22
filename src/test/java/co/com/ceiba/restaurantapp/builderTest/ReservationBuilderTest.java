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
import org.springframework.boot.autoconfigure.cache.CacheProperties.EhCache;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.persistencia.builders.BillBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;

public class ReservationBuilderTest {
	
	
	private static final int DISCOUNT_FOR_PEOPLE = 5000;
	private static final int DISCOUNT_FOR_DAY = 6000;
	private static final float PRICE = 350000;
	private static final float EXPECTED_PRICE = 350000;
	
	private static final Calendar DATE_FOR_DIVISION_DTO  = new GregorianCalendar(
			2019, 9, 12);
	
	@Mock
	private BillEntity billEntity;
	
	@Mock
	private Bill bill;
	
	@Mock
	private BillBuilder billBuilder;
	
	@Mock
	private Reservation reservation;
	
	@Mock
	private ReservationEntity reservationEntity;
	
	@Mock
	ReservationBuilder reservationBuilder;
	
	@InjectMocks
	ReservationBuilderTest reservationBuilderTest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		reservationBuilder = new ReservationBuilder();
		
	}
	
	@Test
	public void converReservationToEntityTest() {
		when(reservationEntity.getReservationDate()).thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservationEntity.getNumberPeople()).thenReturn(5);
		when(reservationEntity.isDecor()).thenReturn(true);
		when(reservationEntity.getBillEntity()).thenReturn(billEntity);
		when(reservationEntity.getBillEntity().getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(reservationEntity.getBillEntity().getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);
		when(reservationEntity.getBillEntity().getPrice()).thenReturn(PRICE);
		when(reservation.getBill()).thenReturn(bill);
		when(bill.getPrice()).thenReturn(PRICE);
		when(bill.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(bill.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);
		when(reservation.getReservationDate()).thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservation.getNumberPeople()).thenReturn(5);
		when(reservation.isDecor()).thenReturn(true);
		
		
		Calendar expectedReservationDay = DATE_FOR_DIVISION_DTO;
		
		ReservationEntity resultReservation = reservationBuilder.convertDtoToEntity(reservation);
		
		assertEquals(expectedReservationDay, resultReservation.getReservationDate());
	}

}
