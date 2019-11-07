package co.com.ceiba.restaurantapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.ReservationRequestDao;
import co.com.ceiba.restaurantapp.persistencia.repositories.ClientRepository;

@Service
public class ReservationRequestService {
	
	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	ClientBuilder clientBuilder;
	 
	@Autowired
	ReservationRequestDao reservationRequestDao;
	
	@Autowired
 	ClientRepository clientRepository;
	
	//por revisar
		public List<ReservationRequest> getReservationRequests() {		
		return reservationRequestDao.getReservationRequests();	
		}

	public void addReservationResquest(ReservationRequest reservationRequest) {

		Client client = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		reservationRequestDao.saveReservationRequest(client); 
	}
 
	public ReservationRequest  ReservationRequestById(int id) {
		return reservationRequestDao.getReservationRequestById(id);
	}

	public void editReservationResquest(ReservationRequest reservationRequest) {
		Client client = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		reservationRequestDao.edit(client);
	}

	public ReservationRequest deleteReservationRequest(int id) { 
		return reservationRequestDao.delete(id);
	}
}
