package co.com.ceiba.restaurantapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.persistencia.repositories.ClientRepository;

@Repository
@Transactional
public class ClientDao {
	@Autowired
	ClientBuilder clientBuilder;
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<>();
		List<ClientEntity> entities = clientRepository.findAll();
		for (ClientEntity clientEntity : entities) {
	 		Client clientDto = clientBuilder.convertClientEntityToClient(clientEntity);
			clients.add(clientDto);
		}
		return clients;
	} 

	public Client getClientById(int id) {
		ClientEntity clientEntity = clientRepository.findById(id);
		 Client client = clientBuilder.convertClientEntityToClient(clientEntity);
		return client;
	}

	public void edit(Client client) {
		ClientEntity clientEntity = clientBuilder.convertClientToRClientEntity(client);
		clientRepository.save(clientEntity);
	}
 
	public Client delete(int id) { 
		ClientEntity clientEntity = clientRepository.findById(id);
		Client client = clientBuilder.convertClientEntityToClient(clientEntity);
		if (client != null) {
			clientRepository.delete(clientEntity);
		} 
		return client;
	}

}
