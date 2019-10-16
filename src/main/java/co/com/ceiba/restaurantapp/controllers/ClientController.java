package co.com.ceiba.restaurantapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/client")

public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping
	public List<Client> getClient() {
		return clientService.getClients();
	}

	@PostMapping
	public void add(@RequestBody Client client) {
		clientService.addClient(client);
	}

	@GetMapping(path = { "/{id}" })
	public Client getClientForId(@PathVariable("id") int id) {
		return clientService.getClientById(id);

	}


	@PutMapping(path = {"/{id}"})
	public void editar(@RequestBody Client client, @PathVariable("id") int id) {
		clientService.edit(client);
	}
	
	  @DeleteMapping(path = {"/{id}"})
	    public Client delete(@PathVariable("id") int  id){
	       return  clientService.delete(id);
	    }


}
