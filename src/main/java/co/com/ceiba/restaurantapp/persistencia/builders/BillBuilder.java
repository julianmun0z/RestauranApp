package co.com.ceiba.restaurantapp.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;

@Configuration
public class BillBuilder {

	@Autowired
	ReservationBuilder reservationBuilder;

	public BillEntity converDtoToEntity(Bill bill) {

		BillEntity billEntity = new BillEntity();

		billEntity.setPrice(bill.getPrice());
		billEntity.setDiscountForPeople(bill.getDiscountForPeople());
		billEntity.setDiscpuntForDays(bill.getDiscpuntForDays());

		return billEntity; 
	}

	public Bill convertEntityToDto(BillEntity billEntity) {

		Bill bill = new Bill();

		bill.setPrice(billEntity.getPrice());
		bill.setDiscountForPeople(billEntity.getDiscountForPeople());
		bill.setDiscpuntForDays(billEntity.getDiscpuntForDays());

		return bill;

	}

}
