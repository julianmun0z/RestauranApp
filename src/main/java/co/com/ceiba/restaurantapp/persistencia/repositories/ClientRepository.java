package co.com.ceiba.restaurantapp.persistencia.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;

@Transactional
public interface ClientRepository extends Repository<ClientEntity, Integer> {

	void save(ClientEntity clientEntity);

	List<ClientEntity> findAll();

	ClientEntity findById(int id);

	void delete(ClientEntity clientEntity);

}
