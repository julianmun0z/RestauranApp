package co.com.ceiba.restaurantapp.testdatabuilder;

import co.com.ceiba.restaurantapp.dominio.BillDto;

public class BillDtoTestbuilder {

	private static final int BILL_ID = 1;
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	private float price;
	private int discountForPeople;
	private int discpuntForDays;
	private int billId;


	public BillDtoTestbuilder() { 
		this.billId=BILL_ID;
		this.price = PRICE;
		this.discountForPeople = DISCOUNTFORPEOPLE;
		this.discpuntForDays = DISCOUNTFORDAYS;

	} 

	public BillDtoTestbuilder whiteBillid(int billId) {
		this.billId = billId;
		return this;

	}
	public BillDtoTestbuilder whitePrice(float price) {
		this.price = price;
		return this;

	}

	public BillDtoTestbuilder whiteDiscountForPeople(int discountPeople) {
		this.discountForPeople = discountPeople;
		return this;

	}

	public BillDtoTestbuilder whiteDiscountForDays(int discountDays) {
		this.discpuntForDays = discountDays;
		return this;

	}
	

	public BillDto build() {
		return new BillDto(billId, price, discountForPeople, discpuntForDays,null);
	}
}
