package co.com.ceiba.restaurantapp.dominio;

import java.util.Date;

public class Reservation {

	private Date reservationDate;
	private int numberPeople;
	private boolean decor;
	private Bill bill;

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	public boolean isDecor() {
		return decor;
	}

	public void setDecor(boolean decor) {
		this.decor = decor;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
