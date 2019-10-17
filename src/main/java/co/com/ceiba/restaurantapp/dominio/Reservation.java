package co.com.ceiba.restaurantapp.dominio;

import java.util.Calendar;


public class Reservation {

	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;
	private Bill bill;

	

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	public void setReservationDate(Calendar reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Calendar getReservationDate() {
		return reservationDate;
	}


	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	

	public void setDecor(boolean decor) {
		this.decor = decor;
	}

	
	
	public boolean isDecor() {
		return decor;
	}

}
