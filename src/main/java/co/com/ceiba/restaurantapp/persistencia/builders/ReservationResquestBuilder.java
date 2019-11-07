package co.com.ceiba.restaurantapp.persistencia.builders;

import org.springframework.context.annotation.Configuration;
import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;

import co.com.ceiba.restaurantapp.dto.ReservationRequest;

@Configuration
public class ReservationResquestBuilder {

	public Client divisionReservationRequest(ReservationRequest reservationRequest) {

		Bill bill = new Bill(0, 0, 0);

		bill.getCaculatePriceAndDiscounts(reservationRequest, bill);

		Reservation reservation = new Reservation(reservationRequest.getReservationDate(),
				reservationRequest.getNumberPeople(), reservationRequest.isDecor(), bill);

		Client client = new Client(reservationRequest.getId(), reservationRequest.getFirstName(), reservationRequest.getLastName(),
				reservationRequest.getEmail(), reservationRequest.getPhoneNumber(), reservation);

		return client;

	}
	
	public ReservationRequest getClientObjectReservationRequest(Client client) {
	
		ReservationRequest reservationRequest = new ReservationRequest();
		
		reservationRequest.setId(client.getClientId());
		reservationRequest.setFirstName(client.getFirstName());
		reservationRequest.setLastName(client.getLastName());
		reservationRequest.setEmail(client.getEmail());
		reservationRequest.setPhoneNumber(client.getPhoneNumber());
		reservationRequest.setReservationDate(client.getReservation().getReservationDate());
		reservationRequest.setDecor(client.getReservation().isDecor());
		reservationRequest.setNumberPeople(client.getReservation().getNumberPeople());
		
		return reservationRequest;
	}

}
