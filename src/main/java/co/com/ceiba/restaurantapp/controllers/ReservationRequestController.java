package co.com.ceiba.restaurantapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.services.ReservationRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/reservationrequest")
public class ReservationRequestController {

	@Autowired
	ReservationRequestService reservationRequestService;
	ReservationRequest reservationRequest; 
	
	@GetMapping 
	public List<ReservationRequest> getReservationRequest() {
		return reservationRequestService.getReservationRequests();
	}
	@PostMapping
	public void add(@RequestBody ReservationRequest reservationRequest) {
		reservationRequestService.addReservationResquest(reservationRequest);
	}
	
	@GetMapping(path = { "/{id}" })
	public ReservationRequest getClientForId(@PathVariable("id") int id) {
		return reservationRequestService.ReservationRequestById(id); 
 
	} 
	
	@PutMapping(path = { "/{id}" })
	public void editar(@RequestBody ReservationRequest reservationRequest, @PathVariable("id") int id) {
		reservationRequestService.editReservationResquest(reservationRequest);
	} 
	
	@DeleteMapping(path = { "/{id}" })
	public ReservationRequest delete(@PathVariable("id") int id){
		return reservationRequestService.deleteReservationRequest(id);
	}
}
 