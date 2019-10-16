package co.com.ceiba.restaurantapp.persistencia.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

	@Id
	@Column(name = "idreservation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;

	@Column(name = "reservationdate")
	@DateTimeFormat(pattern = "yyyy-mm-dd+1")
	private Date reservationDate;

	@Column(name = "numberpeople")
	private int numberPeople;

	private boolean decor;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idbill", nullable = false)
	private BillEntity billEntity;
	


	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	public boolean isDecor() {
		return decor;
	}

	public void setDecor(boolean decor) {
		this.decor = decor;
	}

	public BillEntity getBillEntity() {
		return billEntity;
	}

	public void setBillEntity(BillEntity billEntity) {
		this.billEntity = billEntity;
	}

}
