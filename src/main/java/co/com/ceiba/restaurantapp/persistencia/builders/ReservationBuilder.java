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

	public ReservationEntity convertReservationToReservationEntity(Reservation reservation) {

		ReservationEntity reservationEntity = new ReservationEntity();

		BillEntity billEntity = new BillBuilder().converBillToBillEntity(reservation.getBill());

		reservationEntity.setReservationDate(reservation.getReservationDate());
		reservationEntity.setNumberPeople(reservation.getNumberPeople());
		reservationEntity.setDecor(reservation.isDecor());
		reservationEntity.setBillEntity(billEntity);
		return reservationEntity;
	}

	public Reservation convertReservationEntityToReservation(ReservationEntity reservationEntity) {

		Bill bill = new BillBuilder().convertBillEntityToBill(reservationEntity.getBillEntity());

		Reservation reservation = new Reservation(reservationEntity.getReservationDate(),
				reservationEntity.getNumberPeople(), reservationEntity.isDecor(), bill);

		return reservation;
	}

}
