package co.com.ceiba.restaurantapp.TestDataBuilder;

import co.com.ceiba.restaurantapp.dominio.Bill;

public class BillTestbuilder {

	private static final int BILL_ID = 1;
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	private float price;
	private int discountForPeople;
	private int discpuntForDays;
	private int billId;


	public BillTestbuilder() { 
		this.billId=BILL_ID;
		this.price = PRICE;
		this.discountForPeople = DISCOUNTFORPEOPLE;
		this.discpuntForDays = DISCOUNTFORDAYS;

	} 

	public BillTestbuilder whiteBillid(int billId) {
		this.billId = billId;
		return this;

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
		return new Bill();

	}
}
