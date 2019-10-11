package co.com.ceiba.restaurantapp.servicios;

import java.util.List;

import co.com.ceiba.restaurantapp.dominio.ClientDto;

public interface ClientService {

	void addClient(ClientDto client);

	List<ClientDto> getClients();

	ClientDto getClientById(int id);

	void edit(ClientDto clientDto);

}
