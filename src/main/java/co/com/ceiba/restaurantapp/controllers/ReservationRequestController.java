package co.com.ceiba.restaurantapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.services.ReservationRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/fullreservation")
public class ReservationRequestController {

	@Autowired
	ReservationRequestService reservationRequestService;

	@PostMapping
	public void add(@RequestBody ReservationRequest reservationRequest) {
		reservationRequestService.addBillFull(reservationRequest);
	}

}
