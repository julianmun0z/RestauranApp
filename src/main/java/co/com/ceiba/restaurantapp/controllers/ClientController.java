package co.com.ceiba.restaurantapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.ceiba.restaurantapp.dominio.ClientDto;
import co.com.ceiba.restaurantapp.servicios.ClientService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/client")

public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping
	public List<ClientDto> getClient() {
		return clientService.getClients();
	}

	@PostMapping
	public void add(@RequestBody ClientDto client) {
		clientService.addClient(client);
	}

	@GetMapping(path = { "/{id}" })
	public ClientDto getClientForId(@PathVariable("id") int id) {
		return clientService.getClientById(id);

	}

	@JsonProperty("Bill")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void editar(@RequestBody ClientDto clientDto, @PathVariable("id") int id) {
		clientDto.setClientId(id);
		clientService.edit(clientDto);
	}

}
