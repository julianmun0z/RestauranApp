package co.com.ceiba.restaurantapp.persistencia.builders;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.dominio.exception.error.ErrorHandler;
import co.com.ceiba.restaurantapp.dominio.strategies.ArgumentsValidator;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;

@Configuration
public class ReservationResquestBuilder {

	Calendar CurrentDate =  Calendar.getInstance();

	private static final int PERCENT_DAYS = 20;
	private static final int PERCENT_FOR_PEOPLE = 15;
	private static final int DISCOUNT_SPLITTER = 100;
	private static final int FIXED_DECOR = 30000;
	private static final int VALUE_FOR_PERSON = 50000;
	private static final float FIXED_PRICE = 60000;

	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";
	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";
	private static final String LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION = "LA RESERVA PARA LOS DIAS VIERNES Y SABADOS DEBEN TENER 15 DIAS DE ANTICIPACION";

	ErrorHandler errorHandler;

	public Client divisionDto(ReservationRequest reservationRequest) {

		Bill bill = new Bill();

		getCaculatePrice(reservationRequest, bill, null);

		Reservation reservation = new Reservation();

		reservation.setReservationDate(reservationRequest.getReservationDate());
		reservation.setNumberPeople(reservationRequest.getNumberPeople());
		reservation.setDecor(reservationRequest.isDecor());
		reservation.setBill(bill);

		Client client = new Client();

		client.setFirstName(reservationRequest.getFirstName());
		client.setLastName(reservationRequest.getLastName());
		client.setEmail(reservationRequest.getEmail());
		client.setPhoneNumber(reservationRequest.getPhoneNumber());
		client.setReservation(reservation);

		return client;

	}

	public void getCaculatePrice(ReservationRequest reservationRequest, Bill bill, Exception exception) {
		float price = 0;

		validations(reservationRequest);
		price = giveValueToThePrice(reservationRequest);
		price += getExtraPerson(reservationRequest);
		price -= getDiscuontPerPeople(reservationRequest, price);
		price -= getDiscuntForSpecialDays(reservationRequest, price);
		price += FixedDecor(reservationRequest);
		price = daysWithRestriction(reservationRequest, price);
		bill.setDiscountForPeople((int) getDiscuontPerPeople(reservationRequest, price));
		bill.setDiscpuntForDays((int) getDiscuntForSpecialDays(reservationRequest, price));

		validationForFridatAndSaturday(price);
		bill.setPrice(price);
	}

	/*
	 * method to assign initial price.
	 */
	public float giveValueToThePrice(ReservationRequest reservationRequest) {
		float newPrice = 0;
		if (reservationRequest.getFirstName() != null) {
			newPrice = FIXED_PRICE;
		}
		return newPrice;
	}

	/*
	 * method to place a 15-day restriction for reservations made on Saturdays or
	 * Sundays.
	 */
	
	

	public float daysWithRestriction(ReservationRequest reservationRequest, float price) {
		float restriction = 0;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);
		if ((day == 6 || day == 7) && (differenceBetweenCurrentDateAndReservationDate(reservationRequest) <= 15)) {
			restriction = 0;
		} else {
			restriction = price;
		}

		return restriction;
	}

	/*
	 * method to get a 20% discount for Tuesday and Wednesday.
	 */
	
	public float getDiscuntForSpecialDays(ReservationRequest reservationRequest, float price) {
		float discountDay = 0;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);

		if (day == 3 || day == 4) {
			discountDay = price * PERCENT_DAYS / DISCOUNT_SPLITTER;

		}
		return discountDay;
	}

	/*
	 * method to obtain a 15% discount if the reservation is for 5 people or more.
	 */
	public float getDiscuontPerPeople(ReservationRequest reservationRequest, float price) {
		float discuont = 0;
		if (reservationRequest.getNumberPeople() >= 5) {
			discuont = price * PERCENT_FOR_PEOPLE / DISCOUNT_SPLITTER;
		}
		return discuont;
	}

	/*
	 * method to calculate the value of the price by the number of people
	 */
	public float getExtraPerson(ReservationRequest reservationRequest) {
		float priceExtraPerson = 0;
		priceExtraPerson = VALUE_FOR_PERSON * reservationRequest.getNumberPeople();
		return priceExtraPerson;
	}

	/*
	 * method to give value if decoration is desired
	 */
	public float FixedDecor(ReservationRequest reservationRequest) {
		float valueDecor = 0;
		if (reservationRequest.isDecor() == true) {
			valueDecor = FIXED_DECOR;
		}
		return valueDecor;
	}

	/*
	 * method to calculate difference between the current date and the reservation
	 * date for restrictions
	 */
	public long differenceBetweenCurrentDateAndReservationDate(ReservationRequest reservationRequest) {
		long daysDifference = 0;
		Date fechaEntrada =reservationRequest.getReservationDate().getTime();
		Date fechaHoy = CurrentDate.getTime();
		daysDifference = (fechaEntrada.getTime() - fechaHoy.getTime()) / 86400000;
		return daysDifference;
	}

	/*
	 * method to validate the fields
	 */
	public void validations(ReservationRequest reservationRequest) {
		firstNameFieldValidation(reservationRequest);
		lastNameFieldValidation(reservationRequest);
		emailFieldValidation(reservationRequest);
		reservationDateFieldValidation(reservationRequest);
		numberPeopleFieldValidation(reservationRequest);
	}

	/*
	 * firstName field validation is not empty
	 */
	private void firstNameFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNulle(reservationRequest.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
	}

	/*
	 * The validation of the lastName field is not empty
	 */
	private void lastNameFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getLastName(), EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNulle(reservationRequest.getLastName(), EL_APELLIDO_ES_OBLIGATORIO);
	}

	/*
	 * The validation of the email field is not empty
	 */
	private void emailFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getEmail(), EL_EMAIL_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNulle(reservationRequest.getEmail(), EL_EMAIL_ES_OBLIGATORIO);
	}

	/*
	 * The validation of the reservationDate field is not empty
	 */
	private void reservationDateFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getReservationDate(), LA_FECHA_ES_OBLIGATORIA);
		ArgumentsValidator.restrictionForNulle(reservationRequest.getReservationDate(), LA_FECHA_ES_OBLIGATORIA);
	}

	/*
	 * The validation of the numberPeople field is not empty
	 */
	private void numberPeopleFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForValueZero(reservationRequest.getNumberPeople(),
				EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO);
	}

	/*
	 * method that evaluates if the price ends in zero
	 */
	public void validationForFridatAndSaturday(float price) {
		ArgumentsValidator.restrictionForValueZero(price,
				LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION);
	}
}