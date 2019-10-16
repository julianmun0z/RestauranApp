package co.com.ceiba.restaurantapp.persistencia.dao;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;

@Transactional
public interface ClientDao extends Repository<ClientEntity, Integer> {

	void save(ClientEntity clientEntity);

	List<ClientEntity> findAll();

	ClientEntity findById(int id);

	
	void delete(ClientEntity clientEntity);

}
