package co.com.ceiba.restaurantapp.persistencia.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;


public interface ReservationDao extends Repository<ReservationEntity, Integer> {

	void save(ReservationEntity reservationEntity);

	List<ReservationEntity> findAll();

	ReservationEntity findById(int id);

}
