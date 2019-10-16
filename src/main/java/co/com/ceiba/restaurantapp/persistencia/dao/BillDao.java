package co.com.ceiba.restaurantapp.persistencia.dao;

import org.springframework.data.repository.Repository;

import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;

public interface BillDao extends Repository<BillEntity, Integer> {

	void save(BillEntity billEntity);
}
