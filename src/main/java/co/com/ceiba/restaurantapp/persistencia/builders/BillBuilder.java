package co.com.ceiba.restaurantapp.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;

@Configuration
public class BillBuilder {

	@Autowired
	ReservationBuilder reservationBuilder;

	public BillEntity converBillToBillEntity(Bill bill) {

		BillEntity billEntity = new BillEntity();
		billEntity.setPrice(bill.getPrice()); 
		billEntity.setDiscountForPeople(bill.getDiscountForPeople());
		billEntity.setDiscpuntForDays(bill.getDiscpuntForDays());
		return billEntity;
	}

	public Bill convertBillEntityToBill(BillEntity billEntity) {

		Bill bill = new Bill(billEntity.getPrice(), billEntity.getDiscountForPeople(), billEntity.getDiscpuntForDays());
		return bill;
	}
}
