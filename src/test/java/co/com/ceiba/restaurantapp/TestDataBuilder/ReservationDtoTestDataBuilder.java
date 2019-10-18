package co.com.ceiba.restaurantapp.TestDataBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.com.ceiba.restaurantapp.dominio.Reservation;

public class ReservationDtoTestDataBuilder {

	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2019, 02, 02);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;

	private int idReservation;
	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;

	public ReservationDtoTestDataBuilder() {
		this.reservationDate = RESERVATIONDATE;
		this.numberPeople = NUMBERPEOPLE;
		this.decor = DECOR;
	}

	public ReservationDtoTestDataBuilder whitReservation(Calendar reservationDate) {
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



}
