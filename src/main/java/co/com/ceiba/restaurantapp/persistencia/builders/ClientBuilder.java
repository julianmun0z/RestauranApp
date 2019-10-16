package co.com.ceiba.restaurantapp.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;

@Configuration
public class ClientBuilder {

	@Autowired
	ReservationBuilder reservationBuilder;

	public ClientEntity convertDtoToEntity(Client client) {

		ClientEntity clientEntity = new ClientEntity();

		ReservationEntity reservationEntity = new ReservationBuilder().convertDtoToEntity(client.getReservation());
		clientEntity.setClientId(client.getClientId());
		clientEntity.setFirstName(client.getFirstName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setEmail(client.getEmail());
		clientEntity.setPhoneNumber(client.getPhoneNumber());
		clientEntity.setReservationEntity(reservationEntity);

		return clientEntity;
	}

	public Client convertEntityToDto(ClientEntity clientEntity) {

		Client client = new Client();

		Reservation reservation = new ReservationBuilder().convertEntityToDto(clientEntity.getReservationEntity());

		client.setClientId(clientEntity.getClientId());
		client.setFirstName(clientEntity.getFirstName());
		client.setLastName(clientEntity.getLastName());
		client.setEmail(clientEntity.getEmail());
		client.setPhoneNumber(clientEntity.getPhoneNumber());
		client.setReservation(reservation);

		return client;
	}

}
