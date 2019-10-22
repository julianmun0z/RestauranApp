package co.com.ceiba.restaurantapp.builderTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.persistencia.builders.BillBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;

public class BillBuilderTest {
	
	private static final int NUMBER_PEOPLE = 5;
	private static final int MINUS_NUMBER_PEOPLE = 2;
	private static final float PRICE = 350000;
	private static final float EXPECTED_PRICE = 293500;
	
	@Mock
	private Bill bill;
	@Mock
	private BillEntity billEntity;
	
	@Mock
	private BillBuilder billBuilder;
	
	@InjectMocks
	BillBuilderTest billBuilderTest;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		billBuilder = new BillBuilder();
	}
	
	@Test
	public void converDtoToEntityTest() {
		
		when(billEntity.getPrice()).thenReturn(PRICE);
		when(billEntity.getDiscountForPeople()).thenReturn(NUMBER_PEOPLE);
		when(billEntity.getDiscpuntForDays()).thenReturn(NUMBER_PEOPLE);
		
		float expected = PRICE;
		int expectedDiscountPeople = NUMBER_PEOPLE;
		int expectedDiscountDay = NUMBER_PEOPLE;
		
		Bill result = billBuilder.convertEntityToDto(billEntity);
		
		assertEquals(expected, result.getPrice(),0);
		assertEquals(expectedDiscountPeople, result.getDiscountForPeople());
		assertEquals(expectedDiscountDay, result.getDiscpuntForDays());

		
		
		
	}
	
	@Test
	public void converDtoToEntity() {
		when(bill.getPrice()).thenReturn(PRICE);
		when(bill.getDiscountForPeople()).thenReturn(NUMBER_PEOPLE);
		when(bill.getDiscpuntForDays()).thenReturn(NUMBER_PEOPLE);
		
		float expected = PRICE;
		int expectedDiscountPeople = NUMBER_PEOPLE;
		int expectedDiscountDay = NUMBER_PEOPLE;
		
		
		BillEntity result = billBuilder.converDtoToEntity(bill);
		
		assertEquals(expected, result.getPrice(),0);
		assertEquals(expectedDiscountPeople, result.getDiscountForPeople());
		assertEquals(expectedDiscountDay, result.getDiscpuntForDays());

	}

}
