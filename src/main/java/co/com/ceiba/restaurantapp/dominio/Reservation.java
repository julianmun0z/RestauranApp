package co.com.ceiba.restaurantapp.dominio;

import java.util.Calendar;
import co.com.ceiba.restaurantapp.dominio.strategies.ArgumentsValidator;

public class Reservation {

	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";

	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;
	private Bill bill;

	public Reservation(Calendar reservationDate, int numberPeople, boolean decor, Bill bill) {
		
		ArgumentsValidator.restrictionForNull(reservationDate, LA_FECHA_ES_OBLIGATORIA);
		ArgumentsValidator.restrictionForValueZero(numberPeople, EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO);
		
		this.reservationDate = reservationDate;
		this.numberPeople = numberPeople;
		this.decor = decor;
		this.bill = bill;
	}

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
