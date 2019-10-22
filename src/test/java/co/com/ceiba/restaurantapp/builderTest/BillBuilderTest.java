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

	private static final int DISCOUNT_FOR_PEOPLE = 5000;
	private static final int DISCOUNT_FOR_DAY = 6000;
	private static final float PRICE = 350000;
	private static final float EXPECTED_PRICE = 350000;

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
		//arrange 
		when(billEntity.getBillId()).thenReturn(2);
		when(billEntity.getPrice()).thenReturn(PRICE);
		when(billEntity.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(billEntity.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);
		int expectedBillID = 2;
		float expected = EXPECTED_PRICE;
		int expectedDiscountPeople = DISCOUNT_FOR_PEOPLE;
		int expectedDiscountDay = DISCOUNT_FOR_DAY;

		//act
		Bill result = billBuilder.convertBillEntityToBill(billEntity);

		//assert
		assertEquals(expectedBillID,2);
		assertEquals(expected, result.getPrice(), 0);
		assertEquals(expectedDiscountPeople, result.getDiscountForPeople());
		assertEquals(expectedDiscountDay, result.getDiscpuntForDays());

	}

	@Test
	public void converDtoToEntity() {
		//arrange
		when(bill.getPrice()).thenReturn(PRICE);
		when(bill.getDiscountForPeople()).thenReturn(DISCOUNT_FOR_PEOPLE);
		when(bill.getDiscpuntForDays()).thenReturn(DISCOUNT_FOR_DAY);
		

		float expected = EXPECTED_PRICE;
		int expectedDiscountPeople = DISCOUNT_FOR_PEOPLE;
		int expectedDiscountDay = DISCOUNT_FOR_DAY;
		//act
		BillEntity result = billBuilder.converBillToBillEntity(bill);

		//assert
		assertEquals(expected, result.getPrice(), 0);
		assertEquals(expectedDiscountPeople, result.getDiscountForPeople());
		assertEquals(expectedDiscountDay, result.getDiscpuntForDays());

	}

}
