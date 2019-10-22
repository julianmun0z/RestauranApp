package co.com.ceiba.restaurantapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.Client;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationBuilder;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.BillDao;
import co.com.ceiba.restaurantapp.persistencia.dao.ClientDao;
import co.com.ceiba.restaurantapp.persistencia.dao.ReservationDao;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;

@Service
public class ReservationRequestService {

	@Autowired
	private ReservationDao reservationDao;

	@Autowired
	private BillDao billDao;

	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	ClientBuilder clientBuilder;

	public void addBillFull(ReservationRequest reservationRequest) {

		Client client = reservationResquestBuilder.divisionDto(reservationRequest);
		ClientEntity clientEntity = clientBuilder.convertClientToRClientEntity(client);
		billDao.save(clientEntity.getReservationEntity().getBillEntity());
		reservationDao.save(clientEntity.getReservationEntity());
		clientDao.save(clientEntity);
	}

}
