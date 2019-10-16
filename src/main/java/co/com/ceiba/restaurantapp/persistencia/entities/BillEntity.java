package co.com.ceiba.restaurantapp.persistencia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {

	@Id
	@Column(name = "idbill")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;

	@Column(name = "price")
	private float price;

	@Column(name = "discountforpeople")
	private int discountForPeople;

	@Column(name = "discpuntfordays")
	private int discpuntForDays;
	
	

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

}
