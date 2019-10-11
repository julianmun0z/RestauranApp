package co.com.ceiba.restaurantapp.testdatabuilder;


import java.util.Date;

import co.com.ceiba.restaurantapp.dominio.ReservationDto;


public class ReservationDtoTestDataBuilder {
	
	private static final Date RESERVATIONDATE = new Date(02-02-2019);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;
	
	private int idReservation;
	private Date reservationDate;
	private int numberPeople;
	private boolean decor;
	
	
	public ReservationDtoTestDataBuilder() {
		this.reservationDate = RESERVATIONDATE;
		this.numberPeople = NUMBERPEOPLE;
		this.decor = DECOR;
	}
	
	public ReservationDtoTestDataBuilder whitReservation(Date reservationDate) {
		this.reservationDate = reservationDate;
		return this;
		
	}
	
	public ReservationDtoTestDataBuilder whitNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
		return this;
		
	}
	
	public ReservationDtoTestDataBuilder whiteDecor(boolean decor) {
		this.decor = decor;
		return this;
	}

	
	public ReservationDto buil() {
		return new ReservationDto(idReservation, reservationDate, numberPeople, decor);
	}


}
