package co.com.ceiba.restaurantapp.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurantapp.dominio.Bill;
import co.com.ceiba.restaurantapp.dominio.Reservation;
import co.com.ceiba.restaurantapp.persistencia.entities.BillEntity;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;

@Configuration
public class ReservationBuilder {

	@Autowired
	BillBuilder billBuilder;

	public ReservationEntity convertDtoToEntity(Reservation reservation) {

		ReservationEntity reservationEntity = new ReservationEntity();

		BillEntity billEntity = new BillBuilder().converBillToBillEntity(reservation.getBill());

		reservationEntity.setReservationDate(reservation.getReservationDate());
		reservationEntity.setNumberPeople(reservation.getNumberPeople());
		reservationEntity.setDecor(reservation.isDecor());
		reservationEntity.setBillEntity(billEntity);
		return reservationEntity;
	}

	public Reservation convertReservationEntityToReservation(ReservationEntity reservationEntity) {

	
		Reservation reservation = new Reservation(null, 0, false, null);

		Bill bill = new BillBuilder().convertBillEntityToBill(reservationEntity.getBillEntity());

		reservation.setReservationDate(reservationEntity.getReservationDate());
		reservation.setNumberPeople(reservationEntity.getNumberPeople());
		reservation.setDecor(reservationEntity.isDecor());
		reservation.setBill(bill);

		return reservation; 
	}

}
