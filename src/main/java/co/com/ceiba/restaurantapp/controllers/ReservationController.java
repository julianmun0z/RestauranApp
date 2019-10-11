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

import co.com.ceiba.restaurantapp.dominio.ReservationDto;
import co.com.ceiba.restaurantapp.servicios.ReservationService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/reservation")

public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping
	public List<ReservationDto> getReservation() {
		return reservationService.getReservations();
	}

	@PostMapping
	public void add(@RequestBody ReservationDto reservation) {
		reservationService.addReservation(reservation);
	}

	@GetMapping(path = { "/{id}" })
	public ReservationDto getReservationForId(@PathVariable("id") int id) {
		return reservationService.getReservationById(id);
	}

	@JsonProperty("Bill")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void editar(@RequestBody ReservationDto reservationDto, @PathVariable("id") int id) {
		reservationDto.setIdReservation(id);
		reservationService.edit(reservationDto);
	}

}
