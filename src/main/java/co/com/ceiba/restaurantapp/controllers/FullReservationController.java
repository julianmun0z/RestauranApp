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

import co.com.ceiba.restaurantapp.dominio.BillDto;
import co.com.ceiba.restaurantapp.dominio.FullReservationDto;
import co.com.ceiba.restaurantapp.servicios.BillService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/fullreservation")
public class FullReservationController {

	@Autowired
	BillService billService;

	@GetMapping
	public List<BillDto> getBill() {
		return billService.getBills();
	}

	@PostMapping
	public void add(@RequestBody FullReservationDto fullReservationDto) {
		billService.addBillFull(fullReservationDto);
	}

	@JsonProperty("Bill")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void editar(@RequestBody FullReservationDto fullReservationDto, @PathVariable("id") int id) {
		fullReservationDto.setId(id);
		billService.editfull(fullReservationDto);
	}

}
