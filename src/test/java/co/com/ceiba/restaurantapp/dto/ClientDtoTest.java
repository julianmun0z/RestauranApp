package co.com.ceiba.restaurantapp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.restaurantapp.dominio.ClientDto;
import co.com.ceiba.restaurantapp.testdatabuilder.ClientDtoTestDataBuilder;


public class ClientDtoTest {

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";
	

	@Test
	public void createClientTest() {

		// arrange
		ClientDtoTestDataBuilder clientDtoTestBuilder = new ClientDtoTestDataBuilder()
				.whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME)
				.whiteEmail(EMAIL)
				.whitePhoneNumber(PHONENUMBER);
		
		//act
		ClientDto client = clientDtoTestBuilder.build();
		
		
		//assert
		assertEquals(FIRSTNAME, client.getFirstName());
		assertEquals(LASTNAME, client.getLastName());
		assertEquals(EMAIL, client.getEmail());
		assertEquals(PHONENUMBER, client.getPhoneNumber());
		
		
	}
	
}
