package co.com.ceiba.restaurantapp.dominio;

public class BillDto {

	private int billId;
	private float price;
	private int discountForPeople;
	private int discpuntForDays;
	private ReservationDto reservationDto;

	public BillDto() {
	}

	public BillDto(int billId, float price, int discountForPeople, int discpuntForDays, ReservationDto reservationDto) {

		this.billId = billId;
		this.price = price;
		this.discountForPeople = discountForPeople;
		this.discpuntForDays = discpuntForDays;
		this.reservationDto = reservationDto;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
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

}
