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

	public ClientEntity convertClientToRClientEntity(Client client) {

		ClientEntity clientEntity = new ClientEntity();

		ReservationEntity reservationEntity = new ReservationBuilder()
				.convertReservationToReservationEntity(client.getReservation());
		clientEntity.setClientId(client.getClientId());
		clientEntity.setFirstName(client.getFirstName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setEmail(client.getEmail());
		clientEntity.setPhoneNumber(client.getPhoneNumber());
		clientEntity.setReservationEntity(reservationEntity);
		return clientEntity;
	}

	public Client convertClientEntityToClient(ClientEntity clientEntity) {
		
		Reservation reservation = new ReservationBuilder()
				.convertReservationEntityToReservation(clientEntity.getReservationEntity());

		Client client = new Client(clientEntity.getClientId(), clientEntity.getFirstName(), clientEntity.getLastName(),
				clientEntity.getEmail(), clientEntity.getPhoneNumber(), reservation);

		return client;
	}

}
