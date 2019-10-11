package co.com.ceiba.restaurantapp.dominio;


import java.util.Date;

public class ReservationDto {

	private Integer idReservation;
	private Date reservationDate;
	private int numberPeople;
	private boolean decor;
	private ClientDto clientDto;

	public ReservationDto() {

	}

	public ReservationDto(Integer idReservation, Date reservationDate, int numberPeople, boolean decor) {
		super();
		this.idReservation = idReservation;
		this.reservationDate = reservationDate;
		this.numberPeople = numberPeople;
		this.decor = decor;
	}

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

	public ClientDto getClientDto() {
		return clientDto;
	}

	public void setClientDto(ClientDto clientDto) {
		this.clientDto = clientDto;
	}

}
