package co.com.ceiba.restaurantapp.TestDataBuilder;

import co.com.ceiba.restaurantapp.dominio.Client;

public class ClientDtoTestDataBuilder {

	
	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private int clientId;
	private String firstName;
	private String lastName;
	private String Email;
	private String phoneNumber;

	public ClientDtoTestDataBuilder() {
		this.firstName = FIRSTNAME;
		this.lastName = LASTNAME;
		this.Email = EMAIL;
		this.phoneNumber = PHONENUMBER;
	}

	public ClientDtoTestDataBuilder whitFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ClientDtoTestDataBuilder whitLastName(String lastName) {
		this.lastName = lastName;
		return this;

	}

	public ClientDtoTestDataBuilder whiteEmail(String email) {
		this.Email = email;
		return this;
	}

	public ClientDtoTestDataBuilder whitePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;

	}


}
