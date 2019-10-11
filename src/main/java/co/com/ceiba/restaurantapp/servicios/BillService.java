package co.com.ceiba.restaurantapp.servicios;

import java.util.List;

import co.com.ceiba.restaurantapp.dominio.BillDto;
import co.com.ceiba.restaurantapp.dominio.FullReservationDto;



public interface BillService {

	void addBill(BillDto billDto);

	List<BillDto> getBills();

	BillDto getBillById(int id);

	void edit(BillDto billDto);

	void addBillFull(FullReservationDto fullResevationDto);

	BillDto delete(int id);

	void editfull(FullReservationDto fullReservationDto);

}
