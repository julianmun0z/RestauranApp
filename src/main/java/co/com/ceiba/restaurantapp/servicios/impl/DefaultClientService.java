package co.com.ceiba.restaurantapp.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.ClientDto;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.ClientDao;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.servicios.ClientService;


@Service
public class DefaultClientService implements ClientService {

	@Autowired
	ClientBuilder clientBuilder;
	@Autowired
	private ClientDao clientDao;

	@Override
	public void addClient(ClientDto client) {
		ClientEntity clientEntity = clientBuilder.convertDtoToEntity(client);
		clientDao.save(clientEntity);
	}

	@Override
	public List<ClientDto> getClients() {
		List<ClientDto> clients = new ArrayList<>();
		List<ClientEntity> entities = clientDao.findAll();
		for (ClientEntity clientEntity : entities) {
			ClientDto clientDto = clientBuilder.convertEntityToDto(clientEntity);
			clients.add(clientDto);
		}
		return clients;
	}

	@Override
	public ClientDto getClientById(int id) {
		ClientEntity clientEntity = clientDao.findById(id);
		ClientDto client = clientBuilder.convertEntityToDto(clientEntity);
		return client;
	}

	@Override
	public void edit(ClientDto clientDto) {
		ClientEntity clientEntity = clientBuilder.convertDtoToEntity(clientDto);
		clientDao.save(clientEntity);

	}

}
