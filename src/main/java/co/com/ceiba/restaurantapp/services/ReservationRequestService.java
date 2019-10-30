package co.com.ceiba.restaurantapp.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.strategies.ArgumentsValidator;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.BillDao;
import co.com.ceiba.restaurantapp.persistencia.dao.ClientDao;
import co.com.ceiba.restaurantapp.persistencia.dao.ReservationDao;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;

@Service
public class ReservationRequestService {

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

	@Autowired
	private ReservationDao reservationDao;

	@Autowired
	private BillDao billDao;

	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	ClientBuilder clientBuilder;

	public void addReservationResquest(ReservationRequest reservationRequest) {

		Client client = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		ClientEntity clientEntity = clientBuilder.convertClientToRClientEntity(client);
		clientDao.save(clientEntity);
		reservationDao.save(clientEntity.getReservationEntity());
		billDao.save(clientEntity.getReservationEntity().getBillEntity());

	}

	public Bill getCaculatePriceAndDiscounts(ReservationRequest reservationRequest, Bill bill) {
		float price = 0;

		validationsFields(reservationRequest);
		price = giveValueToThePrice(reservationRequest);
		price += getValueForPerson(reservationRequest);
		price -= getDiscuontPerPeople(reservationRequest, price);
		price -= getDiscountForDaysTuesdayAndWednesday(reservationRequest, price);
		price += getFixedValueDecor(reservationRequest);
		price = daysWithRestriction(reservationRequest, price);
		bill.setDiscountForPeople((int) getDiscuontPerPeople(reservationRequest, price));
		bill.setDiscpuntForDays((int) getDiscountForDaysTuesdayAndWednesday(reservationRequest, price));
		validationForFridatAndSaturday(price);
		bill.setPrice(price);
		return bill;
	}

	public void validationsFields(ReservationRequest reservationRequest) {
		firstNameFieldValidation(reservationRequest);
		lastNameFieldValidation(reservationRequest);
		emailFieldValidation(reservationRequest);
		reservationDateFieldValidation(reservationRequest);
		numberPeopleFieldValidation(reservationRequest);
	}

	public void firstNameFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(reservationRequest.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
	}

	public void lastNameFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getLastName(), EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(reservationRequest.getLastName(), EL_APELLIDO_ES_OBLIGATORIO);
	}

	public void emailFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getEmail(), EL_EMAIL_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(reservationRequest.getEmail(), EL_EMAIL_ES_OBLIGATORIO);
	}

	public void reservationDateFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForNull(reservationRequest.getReservationDate(), LA_FECHA_ES_OBLIGATORIA);
		ArgumentsValidator.restrictionForValueEmpty(reservationRequest.getReservationDate(), LA_FECHA_ES_OBLIGATORIA);
	}

	public void numberPeopleFieldValidation(ReservationRequest reservationRequest) {
		ArgumentsValidator.restrictionForValueZero(reservationRequest.getNumberPeople(),
				EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO);
	}

	public float giveValueToThePrice(ReservationRequest reservationRequest) {
		float newPrice = 0;
		if (reservationRequest.getFirstName() != null) {
			newPrice = FIXED_PRICE;
		}
		return newPrice;
	}

	public float getValueForPerson(ReservationRequest reservationRequest) {
		float priceForPerson = 0;
		priceForPerson = VALUE_FOR_PERSON * reservationRequest.getNumberPeople();
		return priceForPerson;
	}

	public float getDiscuontPerPeople(ReservationRequest reservationRequest, float price) {
		float discuont = 0;
		if (reservationRequest.getNumberPeople() >= 5) {
			discuont = price * PERCENT_FOR_PEOPLE / DISCOUNT_SPLITTER;
		}
		return discuont;
	}

	public float getDiscountForDaysTuesdayAndWednesday(ReservationRequest reservationRequest, float price) {
		float discountDay = 0;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);

		if (day == 3 || day == 4) {
			discountDay = price * PERCENT_DAYS / DISCOUNT_SPLITTER;

		}
		return discountDay;
	}

	public float getFixedValueDecor(ReservationRequest reservationRequest) {
		float valueDecor = 0;
		if (reservationRequest.isDecor()) {
			valueDecor = FIXED_DECOR;
		}
		return valueDecor;
	}

	public float daysWithRestriction(ReservationRequest reservationRequest, float price) {
		float restriction = 0;
		int day = reservationRequest.getReservationDate().get(Calendar.DAY_OF_WEEK);
		long differenceBetweenDates = differenceBetweenCurrentDateAndReservationDate(reservationRequest);
		if ((day == 6 || day == 7) && (differenceBetweenDates <= 15)) {
			restriction = 0;
		} else {
			restriction = price;
		}

		return restriction;
	}

	public long differenceBetweenCurrentDateAndReservationDate(ReservationRequest reservationRequest) {
		long daysDifference = 0;
		Date fechaEntrada = reservationRequest.getReservationDate().getTime();
		Date fechaHoy = reservationRequest.getCurrentDate().getTime();
		daysDifference = (fechaEntrada.getTime() - fechaHoy.getTime()) / 86400000;
		return daysDifference;
	}

	public void validationForFridatAndSaturday(float price) {
		ArgumentsValidator.restrictionForValueZero(price,
				LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION);
	}

}
