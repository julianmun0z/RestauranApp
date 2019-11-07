package co.com.ceiba.restaurantapp.dominio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.restaurantapp.dominio.strategies.ArgumentsValidator;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;

public class Bill {

	private static final float FIXED_PRICE = 60000;
	private static final int VALUE_FOR_PERSON = 50000;
	private static final int PERCENT_FOR_PEOPLE = 15;
	private static final int DISCOUNT_SPLITTER = 100;
	private static final int PERCENT_DAYS = 20;
	private static final int FIXED_DECOR = 30000;
	private static final int FRIDAY = 6;
	private static final int SATURDAY = 7;
	private static final int INITIALIZING_VALUE = 0;
	private static final int MINIMUM_OF_PEOPLE_FOR_DISCOUNT = 5;
	private static final int MAXIMUM_FOR_DAYS_FOR_RESTRICTION = 15;
	private static final int VALUE_SSIGNED_TO_THE_PRICE_FOR_RESTRICTION = 0;
	private static final int TUESDAY = 3;
	private static final int WEDNESDAY = 4;
	private static final int MILLISECOND = 86400000;

	private static final String LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION = "LA RESERVA PARA LOS DIAS VIERNES Y SABADOS DEBEN TENER 15 DIAS DE ANTICIPACION";

	private float price;
	private int discountForPeople;
	private int discpuntForDays;

	public Bill(float price, int discountForPeople, int discpuntForDays) {
		this.price = price;
		this.discountForPeople = discountForPeople;
		this.discpuntForDays = discpuntForDays;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public int getDiscountForPeople() {
		return discountForPeople;
	}

	public void setDiscountForPeople(int discountForPeople) {
		this.discountForPeople = discountForPeople;
	}

	public int getDiscpuntForDays() {
		return discpuntForDays;
	}

	public void setDiscpuntForDays(int discpuntForDays) {
		this.discpuntForDays = discpuntForDays;
	}

	public Bill getCaculatePriceAndDiscounts(ReservationRequest reservationRequest, Bill bill) {
		float price = INITIALIZING_VALUE;
		price = giveValueToThePrice(reservationRequest);
		price += getValueForPerson(reservationRequest);
		price -= getDiscuontPerPeople(reservationRequest, price);
		price -= getDiscountForDaysTuesdayAndWednesday(reservationRequest, price);
		price += getFixedValueDecor(reservationRequest);
		price = daysWithRestriction(reservationRequest, price);
		bill.setDiscountForPeople((int) getDiscuontPerPeople(reservationRequest, price));
		bill.setDiscpuntForDays((int) getDiscountForDaysTuesdayAndWednesday(reservationRequest, price));
		bill.setPrice(price);
		validationForFridatAndSaturday(price);
		return bill;
	}

	public float giveValueToThePrice(ReservationRequest reservationRequest) {
		float newPrice = INITIALIZING_VALUE;
		if (reservationRequest.getFirstName() != null) {
			newPrice = FIXED_PRICE;
		}
		return newPrice;
	}

	public float getValueForPerson(ReservationRequest reservationRequest) {
		float priceForPerson = INITIALIZING_VALUE;
		priceForPerson = VALUE_FOR_PERSON * reservationRequest.getNumberPeople();
		return priceForPerson;
	}

	public float getDiscuontPerPeople(ReservationRequest reservationRequest, float price) {
		float discuont = INITIALIZING_VALUE;
		if (reservationRequest.getNumberPeople() >= MINIMUM_OF_PEOPLE_FOR_DISCOUNT) {
			discuont = price * PERCENT_FOR_PEOPLE / DISCOUNT_SPLITTER;
		}
		return discuont;
	}

	public float getDiscountForDaysTuesdayAndWednesday(ReservationRequest reservationRequest, float price) {
		float discountDay = INITIALIZING_VALUE;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);

		if (day == TUESDAY || day == WEDNESDAY) {
			discountDay = price * PERCENT_DAYS / DISCOUNT_SPLITTER;

		}
		return discountDay;
	}

	public float getFixedValueDecor(ReservationRequest reservationRequest) {
		float valueDecor = INITIALIZING_VALUE;
		if (reservationRequest.isDecor()) {
			valueDecor = FIXED_DECOR;
		}
		return valueDecor;
	}

	public float daysWithRestriction(ReservationRequest reservationRequest, float validation) {
		float restriction = INITIALIZING_VALUE;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);
		long differenceBetweenDates = differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		if ((day == FRIDAY || day == SATURDAY) && (differenceBetweenDates <= MAXIMUM_FOR_DAYS_FOR_RESTRICTION)) {
			restriction = VALUE_SSIGNED_TO_THE_PRICE_FOR_RESTRICTION;
		} else {
			restriction = validation;
		}
		return restriction;
	}

	public long differenceBetweenCurrentDateAndReservationDate(ReservationRequest reservationRequest) {
		long daysDifference = INITIALIZING_VALUE;
		Date fechaEntrada = reservationRequest.getReservationDate().getTime();
		Date fechaHoy = reservationRequest.getCurrentDate().getTime();
		daysDifference = (fechaEntrada.getTime() - fechaHoy.getTime()) / MILLISECOND;
		return daysDifference;
	}

	public void validationForFridatAndSaturday(float price) {
		ArgumentsValidator.restrictionForValueZero(price,
				LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION);
	}

}
