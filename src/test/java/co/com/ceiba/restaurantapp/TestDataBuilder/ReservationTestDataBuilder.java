package co.com.ceiba.restaurantapp.TestDataBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.com.ceiba.restaurantapp.dominio.Reservation;

public class ReservationTestDataBuilder {

	private static final Calendar RESERVATIONDATE = new GregorianCalendar(2019, 02, 02);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = true;

	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;

	public ReservationTestDataBuilder() {
		this.reservationDate = RESERVATIONDATE;
		this.numberPeople = NUMBERPEOPLE;
		this.decor = DECOR;
	}

	public ReservationTestDataBuilder whitReservation(Calendar reservationDate) {
		this.reservationDate = reservationDate;
		return this;

	}

	public ReservationTestDataBuilder whitNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
		return this;

	}

	public ReservationTestDataBuilder whiteDecor(boolean decor) {
		this.decor = decor;
		return this;
	}
	
	

	public Reservation build() {
		return new Reservation(reservationDate, numberPeople, decor, null);
}


}
