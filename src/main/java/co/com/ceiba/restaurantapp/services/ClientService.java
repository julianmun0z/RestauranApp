package co.com.ceiba.restaurantapp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.ClientDao;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;

@Service
public class ClientService {

	@Autowired
	ClientBuilder clientBuilder;
	@Autowired
	private ClientDao clientDao;

	public void addClient(Client client) {
		ClientEntity clientEntity = clientBuilder.convertDtoToEntity(client);
		clientDao.save(clientEntity);
	}

	public List<Client> getClients() {
		List<Client> clients = new ArrayList<>();
		List<ClientEntity> entities = clientDao.findAll();
		for (ClientEntity clientEntity : entities) {
			Client clientDto = clientBuilder.convertEntityToDto(clientEntity);
			clients.add(clientDto);
		}
		return clients;
	}

	public Client getClientById(int id) {
		ClientEntity clientEntity = clientDao.findById(id);
		 Client client = clientBuilder.convertEntityToDto(clientEntity);
		return client;
	}

	public void edit(Client client) {
		ClientEntity clientEntity = clientBuilder.convertDtoToEntity(client);
		clientDao.save(clientEntity);

	}

	public Client delete(int id) {
		ClientEntity clientEntity = clientDao.findById(id);
		Client client = clientBuilder.convertEntityToDto(clientEntity);
		if (client != null) {
			clientDao.delete(clientEntity);

		}
		return client;

	}

}
