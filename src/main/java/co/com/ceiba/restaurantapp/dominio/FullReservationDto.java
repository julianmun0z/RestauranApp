package co.com.ceiba.restaurantapp.dominio;

import java.util.Date;

public class FullReservationDto {

	private Integer id;
	private Integer clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	private Integer idReservation;
	private Date reservationDate;
	private int numberPeople;
	private boolean decor;
	private ClientDto clientDto;

	private float price;
	private int discountForPeople;
	private int discpuntForDays;
	private ReservationDto reservationDto;

	public FullReservationDto() {
		super();
	}

	public FullReservationDto(Integer id, Integer clientId, String firstName, String lastName, String email,
			String phoneNumber, Integer idReservation, Date reservationDate, int numberPeople, boolean decor,
			ClientDto clientDto, float price, int discountForPeople, int discpuntForDays,
			ReservationDto reservationDto) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.idReservation = idReservation;
		this.reservationDate = reservationDate;
		this.numberPeople = numberPeople;
		this.decor = decor;
		this.clientDto = clientDto;
		this.price = price;
		this.discountForPeople = discountForPeople;
		this.discpuntForDays = discpuntForDays;
		this.reservationDto = reservationDto;
	}

	Date concurenDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscountForPeople() {
		return discountForPeople;
	}

	public void setDiscountForPeople(int discountForPeople) {
		this.discountForPeople = discountForPeople;
	}

	public int getDiscpuntForDays() {
		return discpuntForDays;
	}

	public void setDiscpuntForDays(int discpuntForDays) {
		this.discpuntForDays = discpuntForDays;
	}

	public ReservationDto getReservationDto() {
		return reservationDto;
	}

	public void setReservationDto(ReservationDto reservationDto) {
		this.reservationDto = reservationDto;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getConcurenDate() {
		return concurenDate;
	}

	public void setConcurenDate(Date concurenDate) {
		this.concurenDate = concurenDate;
	}

}
