package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import co.com.ceiba.restaurantapp.TestDataBuilder.BillTestbuilder;
import co.com.ceiba.restaurantapp.dominio.Bill;


public class BillTest {


	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	@InjectMocks
	private Bill bill = new Bill(0, 0, 0);
	
	@Test
	public void createBillTest() {
		
		// arrange
		BillTestbuilder billTestbuilder = new BillTestbuilder()
				.whitePrice(PRICE)
				.whiteDiscountForPeople(DISCOUNTFORPEOPLE)
				.whiteDiscountForDays(DISCOUNTFORDAYS);
		
		//act
		Bill bill = billTestbuilder.build();
		
		//assert
	
		assertEquals(PRICE, bill.getPrice(),0);
		assertEquals(DISCOUNTFORPEOPLE, bill.getDiscountForPeople());
		assertEquals(DISCOUNTFORDAYS, bill.getDiscpuntForDays());
	}
	
}
