package co.com.ceiba.restaurantapp.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import co.com.ceiba.restaurantapp.TestDataBuilder.BillTestbuilder;

public class BillTest {


	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	@InjectMocks
	private Bill billDto = new Bill();
	
	@Test
	public void createwhitePriceTest() {
		
		// arrange
		BillTestbuilder billTestbuilder = new BillTestbuilder()
				.whitePrice(PRICE);

		
		//act
		BillTestbuilder bill = billTestbuilder.whitePrice(PRICE);
		
		//assert
	
		assertEquals(billTestbuilder, bill);
	}
	
	@Test
	public void createwhiteDiscountForPeopleTest() {
		
		// arrange
		BillTestbuilder billTestbuilder = new BillTestbuilder()
				.whiteDiscountForPeople(DISCOUNTFORPEOPLE);
//				.whiteDiscountForDays(DISCOUNTFORDAYS);
		
		//act
		BillTestbuilder bill = billTestbuilder.whiteDiscountForPeople(DISCOUNTFORPEOPLE);
		
		//assert
	
		assertEquals(billTestbuilder, bill);

	}
	
	@Test
	public void createwhiteDiscountForDaysTest() {
		
		// arrange
		BillTestbuilder billTestbuilder = new BillTestbuilder()
				.whiteDiscountForDays(DISCOUNTFORDAYS);
		
		//act
		BillTestbuilder bill = billTestbuilder.whiteDiscountForDays(DISCOUNTFORDAYS);
		
		//assert
	
		assertEquals(billTestbuilder, bill);

	}
	
}
