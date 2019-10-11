package co.com.ceiba.restaurantapp.servicios;

import java.util.List;

import co.com.ceiba.restaurantapp.dominio.ReservationDto;

public interface ReservationService {

	void addReservation(ReservationDto reservation);

	List<ReservationDto> getReservations();

	ReservationDto getReservationById(int id);

	void edit(ReservationDto reservationDto);
}
