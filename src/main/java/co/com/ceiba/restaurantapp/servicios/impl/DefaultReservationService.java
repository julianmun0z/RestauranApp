package co.com.ceiba.restaurantapp.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurantapp.dominio.ReservationDto;
import co.com.ceiba.restaurantapp.persistencia.builders.ReservationBuilder;
import co.com.ceiba.restaurantapp.persistencia.dao.ReservationDao;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;
import co.com.ceiba.restaurantapp.servicios.ReservationService;


@Service
public class DefaultReservationService implements ReservationService {

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	private ReservationDao reservationDao;

	@Override
	public void addReservation(ReservationDto reservation) {
		ReservationEntity reservationEntity = reservationBuilder.convertDtoToEntity(reservation);
		reservationDao.save(reservationEntity);

	}

	@Override
	public List<ReservationDto> getReservations() {
		List<ReservationDto> reservations = new ArrayList<>();
		List<ReservationEntity> entitis = reservationDao.findAll();
		for (ReservationEntity reservationEntity : entitis) {
			ReservationDto reservationDto = reservationBuilder.convertEntityToDto(reservationEntity);
			reservations.add(reservationDto);

		}

		return reservations;
	}

	@Override
	public ReservationDto getReservationById(int id) {
		ReservationEntity reservationEntity = reservationDao.findById(id);
		ReservationDto reservationDto = reservationBuilder.convertEntityToDto(reservationEntity);
		return reservationDto;
	}

	@Override
	public void edit(ReservationDto reservationDto) {
		ReservationEntity reservationEntity = reservationBuilder.convertDtoToEntity(reservationDto);
		reservationDao.save(reservationEntity);

	}

}
