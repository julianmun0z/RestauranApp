package co.com.ceiba.restaurantapp.TestDataBuilder;

import java.util.Calendar;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;

public class BillTestbuilder {

	
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	private float price;
	private int discountForPeople;
	private int discpuntForDays;
	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;



	public BillTestbuilder() { 
		
		this.price = PRICE;
		this.discountForPeople = DISCOUNTFORPEOPLE;
		this.discpuntForDays = DISCOUNTFORDAYS;

	} 
 

	public BillTestbuilder whitePrice(float price) {
		this.price = price;
		return this;

	}

	public BillTestbuilder whiteDiscountForPeople(int discountPeople) {
		this.discountForPeople = discountPeople;
		return this;

	}

	public BillTestbuilder whiteDiscountForDays(int discountDays) {
		this.discpuntForDays = discountDays;
		return this;

	}
	
	public Bill build() {
		return new Bill(price, discountForPeople, discpuntForDays);
}
	 
}
