package co.com.ceiba.restaurantapp.testcontrollers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.restaurantapp.dominio.ClientDto;
import co.com.ceiba.restaurantapp.persistencia.builders.ClientBuilder;
import co.com.ceiba.restaurantapp.persistencia.entities.ClientEntity;
import co.com.ceiba.restaurantapp.testdatabuilder.ClientDtoTestDataBuilder;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientTestController {

	@Autowired
	private MockMvc mvc;

	ClientDto client = new ClientDtoTestDataBuilder().whitFirstName("Juan").whitLastName("Gomez")
			.whiteEmail("juan@g.com").whitePhoneNumber("316-000-3456").build();

	ClientEntity clientEntitiy = new ClientBuilder().convertDtoToEntity(client);

	@Test
	public void createClient() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/client").content(asJsonString(clientEntitiy))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getClient() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/client").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

}
