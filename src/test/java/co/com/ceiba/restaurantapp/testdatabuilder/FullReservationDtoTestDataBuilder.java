package co.com.ceiba.restaurantapp.testdatabuilder;

import java.util.Date;

import co.com.ceiba.restaurantapp.dominio.FullReservationDto;


public class FullReservationDtoTestDataBuilder {
	
	private static final int BILL_ID = 1;
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";
	
	private static final Date RESERVATIONDATE = new Date(02-02-2019);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;
	

	private Integer billId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	
	private Date reservationDate;
	private int numberPeople;
	private boolean decor;

	private float price;
	private int discountForPeople;
	private int discpuntForDays; 
	
	public FullReservationDtoTestDataBuilder (){
		this.billId = BILL_ID;
		this.firstName= FIRSTNAME;
		this.lastName = LASTNAME;
		this.email = EMAIL;
		this.phoneNumber = PHONENUMBER;
		this.reservationDate = RESERVATIONDATE;
		this.numberPeople = NUMBERPEOPLE;
		this.price=PRICE;
		this.discountForPeople = DISCOUNTFORPEOPLE;
		this.discpuntForDays = DISCOUNTFORDAYS;

	}
	
	public FullReservationDtoTestDataBuilder whitFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public FullReservationDtoTestDataBuilder whitLastName(String lastName) {
		this.lastName = lastName;
		return this;

	}

	public FullReservationDtoTestDataBuilder whiteEmail(String email) {
		this.email = email;
		return this;
	}

	public FullReservationDtoTestDataBuilder whitePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;

	}
	
	public FullReservationDtoTestDataBuilder whitReservation(Date reservationDate) {
		this.reservationDate = reservationDate;
		return this;
		
	}
	
	public FullReservationDtoTestDataBuilder whitNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
		return this;
		
	}
	
	public FullReservationDtoTestDataBuilder whiteDecor(boolean decor) {
		this.decor = decor;
		return this;
	}
	
	public FullReservationDtoTestDataBuilder whiteBillid(int billId) {
		this.billId = billId;
		return this;

	}
	public FullReservationDtoTestDataBuilder whitePrice(float price) {
		this.price = price;
		return this;

	}

	public FullReservationDtoTestDataBuilder whiteDiscountForPeople(int discountPeople) {
		this.discountForPeople = discountPeople;
		return this;

	}

	public FullReservationDtoTestDataBuilder whiteDiscountForDays(int discountDays) {
		this.discpuntForDays = discountDays;
		return this;

	}
	
	public FullReservationDto build () {
		return new FullReservationDto( billId, billId, firstName, lastName, email, phoneNumber, billId, reservationDate, numberPeople, decor, null, price, discountForPeople, discpuntForDays, null, reservationDate);
	}
	
	
}
