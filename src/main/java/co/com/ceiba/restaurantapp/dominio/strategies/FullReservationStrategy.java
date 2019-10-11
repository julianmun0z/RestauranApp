package co.com.ceiba.restaurantapp.dominio.strategies;

import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurantapp.dominio.BillDto;
import co.com.ceiba.restaurantapp.dominio.ClientDto;
import co.com.ceiba.restaurantapp.dominio.FullReservationDto;
import co.com.ceiba.restaurantapp.dominio.ReservationDto;
import co.com.ceiba.restaurantapp.dominio.exception.error.ErrorHandler;


@Configuration
public class FullReservationStrategy {

	private static final float FIXED_PRICE = 60000;
	private static final int VALUE_FOR_PERSON = 50000;
	private static final int PERCENT_DAYS = 20;
	private static final int PERCENT_FOR_PEOPLE = 15;
	private static final int DISCOUNT_SPLITTER = 100;
	private static final int FIXED_DECOR = 30000;
	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";
	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";
	private static final String LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION = "LA RESERVA PARA LOS DIAS VIERNES Y SABADOS DEBEN TENER 15 DIAS DE ANTICIPACION";

	ErrorHandler errorHandler;

	public BillDto divisionDtoToClient(FullReservationDto fullReservationDto) {

		ClientDto clientDto = new ClientDto();

		clientDto.setClientId(fullReservationDto.getClientId());
		clientDto.setFirstName(fullReservationDto.getFirstName());
		clientDto.setLastName(fullReservationDto.getLastName());
		clientDto.setEmail(fullReservationDto.getEmail());
		clientDto.setPhoneNumber(fullReservationDto.getPhoneNumber());

		ReservationDto reservationDto = new ReservationDto();

		reservationDto.setIdReservation(fullReservationDto.getIdReservation());
		reservationDto.setReservationDate(fullReservationDto.getReservationDate());
		reservationDto.setNumberPeople(fullReservationDto.getNumberPeople());
		reservationDto.setDecor(fullReservationDto.isDecor());

		reservationDto.setClientDto(clientDto);

		BillDto billDto = new BillDto();
		billDto.setReservationDto(reservationDto);
		getCaculatePrice(fullReservationDto, billDto, null);
		return billDto;

	}

	public void getCaculatePrice(FullReservationDto fullReservationDto, BillDto billDto, Exception exception) {
		float price = 0;

		price = setFixedPrice(fullReservationDto);
		price += getExtraPerson(fullReservationDto);
		price -= getDiscuontPerPeople(fullReservationDto, price);
		price -= getDiscuntForSpecialDays(fullReservationDto, price);
		price += FixedDecor(fullReservationDto);
		price = daysWithRestriction(fullReservationDto, price);
		billDto.setDiscountForPeople((int) getDiscuontPerPeople(fullReservationDto, price));
		billDto.setDiscpuntForDays((int) getDiscuntForSpecialDays(fullReservationDto, price));
		validations(fullReservationDto);
		validationForFridatAndSaturday(price);
		billDto.setPrice(price);
	}

	@Deprecated
	public float daysWithRestriction(FullReservationDto fullReservationDto, float price) {
		float restriction = 0;
		if ((fullReservationDto.getReservationDate().getDay() == 4
				|| fullReservationDto.getReservationDate().getDay() == 5)
				&& (differenceBetweenCurrentDateAndReservationDate(fullReservationDto) <= 15)) {
			restriction = 0;
		} else {
			restriction = price;
		}

		return restriction;

	}

	@Deprecated
	public float getDiscuntForSpecialDays(FullReservationDto fullReservationDto, float price) {
		float discountDay = 0;
		if (fullReservationDto.getReservationDate().getDay() == 2
				|| fullReservationDto.getReservationDate().getDay() == 3) {
			discountDay = price * PERCENT_DAYS / DISCOUNT_SPLITTER;

		}
		return discountDay;
	}

	public float getDiscuontPerPeople(FullReservationDto fullReservationDto, float price) {
		float discuont = 0;
		if (fullReservationDto.getNumberPeople() >= 5) {
			discuont = price * PERCENT_FOR_PEOPLE / DISCOUNT_SPLITTER;
		}

		return discuont;
	}

	public float getExtraPerson(FullReservationDto fullReservationDto) {
		float priceExtraPerson = 0;
		priceExtraPerson = VALUE_FOR_PERSON * fullReservationDto.getNumberPeople();
		return priceExtraPerson;
	}

	public float setFixedPrice(FullReservationDto fullReservationDto) {
		fullReservationDto.setPrice(FIXED_PRICE);
		return fullReservationDto.getPrice();
	}

	public float FixedDecor(FullReservationDto fullReservationDto) {
		float valueDecor = 0;
		if (fullReservationDto.isDecor() == true) {
			valueDecor = FIXED_DECOR;
		}
		return valueDecor;
	}

	@Deprecated
	public long differenceBetweenCurrentDateAndReservationDate(FullReservationDto fullReservation) {
		long daysDifference = 0;

		daysDifference = (fullReservation.getReservationDate().getTime() - fullReservation.getConcurenDate().getTime())
				/ 86400000;

		return daysDifference;
	}

	public void validations(FullReservationDto fullReservationDto) {
		ArgumentsValidator.restrictionForNull(fullReservationDto.getFirstName(), EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(fullReservationDto.getLastName(), EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(fullReservationDto.getEmail(), EL_EMAIL_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(fullReservationDto.getReservationDate(), LA_FECHA_ES_OBLIGATORIA);
		ArgumentsValidator.restrictionForValueZero(fullReservationDto.getNumberPeople(),
				EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO);
	}

	public void validationForFridatAndSaturday(float price) {
		ArgumentsValidator.restrictionForValueZero(price,
				LA_RESERERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACIONRERVA_PARA_VIERNES_SABADO_DEBE_TENER_15_DIAS_ANTICIPACION);
	}

}
