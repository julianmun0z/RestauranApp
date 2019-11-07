package co.com.ceiba.restaurantapp.persistencia.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.persistencia.repositories.BillRepository;
import co.com.ceiba.restaurantapp.persistencia.repositories.ClientRepository;
import co.com.ceiba.restaurantapp.persistencia.repositories.ReservationRepository;

@Repository
@Transactional
public class ReservationRequestDao {

	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ClientBuilder clientBuilder;
	
	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;
	
	public List<ReservationRequest> getReservationRequests() {	
		List<ReservationRequest> requests = new ArrayList<>();
		List<Client> clients = new ArrayList<>();
		List<ClientEntity> entities = clientRepository.findAll();		
		
		for (ClientEntity clientEntity : entities) {
	 		Client clientDto = clientBuilder.convertClientEntityToClient(clientEntity);
			clients.add(clientDto);
		}		
		for(Client client:clients) {
			ReservationRequest request = reservationResquestBuilder.getClientObjectReservationRequest(client);
			requests.add(request);
		}		
	return requests;	
	}
	
	public void saveReservationRequest( Client client ) {
	ClientEntity clientEntity = clientBuilder.convertClientToRClientEntity(client);
	clientRepository.save(clientEntity);
	reservationRepository.save(clientEntity.getReservationEntity());
	billRepository.save(clientEntity.getReservationEntity().getBillEntity());
	}
	
	public ReservationRequest getReservationRequestById(int id) {
		ClientEntity clientEntity = clientRepository.findById(id);
		 Client client = clientBuilder.convertClientEntityToClient(clientEntity);
		 ReservationRequest reservationRequest = reservationResquestBuilder.getClientObjectReservationRequest(client);
		return reservationRequest;
	}
	
	public void edit(Client client) {
		ClientEntity clientEntity = clientBuilder.convertClientToRClientEntity(client);
		clientRepository.save(clientEntity);
	}
	
	public ReservationRequest delete(int id) { 
		ClientEntity clientEntity = clientRepository.findById(id);
		Client client = clientBuilder.convertClientEntityToClient(clientEntity);
		ReservationRequest reservationRequest = reservationResquestBuilder.getClientObjectReservationRequest(client);
		if (client != null) {
			clientRepository.delete(clientEntity);
		}
		return reservationRequest;
	}
}

