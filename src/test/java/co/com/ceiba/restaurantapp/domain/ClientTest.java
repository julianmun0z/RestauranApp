package co.com.ceiba.restaurantapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.restaurantapp.TestDataBuilder.ClientTestDataBuilder;
import co.com.ceiba.restaurantapp.dominio.Client;

public class ClientTest {

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private static final String FIRSTNAME_NULL = null;
	private static final String LASTNAME_NULL = null;
	private static final String EMAIL_NULL = null;
	
	private static final String FIRSTNAME_EMPTY = "";
	private static final String LASTNAME_EMPTY = "";
	private static final String EMAIL_EMPTY = "";

	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";

	@Test
	public void createClientTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME).whiteEmail(EMAIL).whitePhoneNumber(PHONENUMBER);

		// act
		Client client = clientDtoTestBuilder.build();

		// assert
		assertEquals(FIRSTNAME, client.getFirstName());
		assertEquals(LASTNAME, client.getLastName());
		assertEquals(EMAIL, client.getEmail());
		assertEquals(PHONENUMBER, client.getPhoneNumber());

	}

	@Test
	public void clientFirstNameValidationTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME_NULL);
		String expectedMessage = EL_NOMBRE_ES_OBLIGATORIO;
		String messageResult = "";

		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}

		// assert
		assertEquals(expectedMessage, messageResult);

	}
	
	@Test
	public void emptyClientFirstNameValidationTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME_EMPTY);
		String expectedMessage = EL_NOMBRE_ES_OBLIGATORIO;
		String messageResult = "";

		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}

		// assert
		assertEquals(expectedMessage, messageResult);

	}

	@Test
	public void clientLastNameValidationTest() {
		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME_NULL);
		String expectedMessage = EL_APELLIDO_ES_OBLIGATORIO;
		String messageResult = "";
		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		// assert
		assertEquals(expectedMessage, messageResult);
	}
	
	@Test
	public void emptyClientLastNameValidationTest() {
		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME_EMPTY);
		String expectedMessage = EL_APELLIDO_ES_OBLIGATORIO;
		String messageResult = "";
		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		// assert
		assertEquals(expectedMessage, messageResult);
	}

	@Test
	public void clientEmailValidationTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME).whiteEmail(EMAIL_NULL);
		String expectedMessage = EL_EMAIL_ES_OBLIGATORIO;
		String messageResult = "";

		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		// assert
		assertEquals(expectedMessage, messageResult);

	}
	
	@Test
	public void emptyClientEmailValidationTest() {

		// arrange
		ClientTestDataBuilder clientDtoTestBuilder = new ClientTestDataBuilder().whitFirstName(FIRSTNAME)
				.whitLastName(LASTNAME).whiteEmail(EMAIL_EMPTY);
		String expectedMessage = EL_EMAIL_ES_OBLIGATORIO;
		String messageResult = "";

		// act
		try {
			clientDtoTestBuilder.build();
			fail();
		} catch (Exception e) {
			messageResult = e.getMessage();
		}
		// assert
		assertEquals(expectedMessage, messageResult);

	}
}
