package co.com.ceiba.restaurantapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.ClientDao;
import co.com.ceiba.restaurantapp.persistencia.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientBuilder clientBuilder;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ClientDao clientDao;
	
	public List<Client> getClients() {
		return clientDao.getClients();
	} 

	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}

	public void edit(Client client) {
		clientDao.edit(client);
	}
 
	public Client delete(int id) { 
		return clientDao.delete(id);
	}

}
