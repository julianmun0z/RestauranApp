package co.com.ceiba.restaurantapp.persistencia.builders;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;

import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.services.ReservationRequestService;

@Configuration
public class ReservationResquestBuilder {

	@Autowired
	ReservationRequestService reservationRequestService;

	

	public Client divisionDto(ReservationRequest reservationRequest) {

		Bill bill = new Bill(0, 0, 0);

		reservationRequestService.getCaculatePriceAndDiscounts(reservationRequest, bill);

		Reservation reservation = new Reservation(null, 0, false, bill);

		reservation.setReservationDate(reservationRequest.getReservationDate());
		reservation.setNumberPeople(reservationRequest.getNumberPeople());
		reservation.setDecor(reservationRequest.isDecor());
		reservation.setBill(bill);

		Client client = new Client(null, null, null, null, null, reservation);

		client.setFirstName(reservationRequest.getFirstName());
		client.setLastName(reservationRequest.getLastName());
		client.setEmail(reservationRequest.getEmail());
		client.setPhoneNumber(reservationRequest.getPhoneNumber());
		client.setReservation(reservation);

		return client; 

	}



	
}
