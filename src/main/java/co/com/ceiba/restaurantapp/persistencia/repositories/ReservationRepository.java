package co.com.ceiba.restaurantapp.persistencia.repositories;

import org.springframework.data.repository.Repository;

import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;

public interface ReservationRepository extends Repository<ReservationEntity, Integer> {

	void save(ReservationEntity reservationEntity);

}
