package co.com.ceiba.restaurantapp.dominio;

public class Bill {

	private float price;
	private int discountForPeople;
	private int discpuntForDays;

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

}
