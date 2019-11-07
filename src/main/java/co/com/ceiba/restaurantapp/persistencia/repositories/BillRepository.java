package co.com.ceiba.restaurantapp.persistencia.repositories;

import org.springframework.data.repository.Repository;

import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;

public interface BillRepository extends Repository<BillEntity, Integer> {

	void save(BillEntity billEntity);
}
