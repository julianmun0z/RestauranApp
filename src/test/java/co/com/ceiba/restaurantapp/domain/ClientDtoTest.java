package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.restaurantapp.TestDataBuilder.ClientTestDataBuilder;
import co.com.ceiba.restaurantapp.dominio.Client;

public class ClientDtoTest {

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";
	

	@Test
	public void createClientTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder()
				.whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME)
				.whiteEmail(EMAIL)
				.whitePhoneNumber(PHONENUMBER);
		
		//act
		Client client = clientDtoTestBuilder.build();
		
		
		//assert
		assertEquals(FIRSTNAME, client.getFirstName());
		assertEquals(LASTNAME, client.getLastName());
		assertEquals(EMAIL, client.getEmail());
		assertEquals(PHONENUMBER, client.getPhoneNumber());
		
		
	}
	
}
