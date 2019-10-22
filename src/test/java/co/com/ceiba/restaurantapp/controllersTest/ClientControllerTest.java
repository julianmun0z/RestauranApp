package co.com.ceiba.restaurantapp.controllersTest;




import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.restaurantapp.TestDataBuilder.ClientTestDataBuilder;
import co.com.ceiba.restaurantapp.controllers.ClientController;
import co.com.ceiba.restaurantapp.dominio.Client;

import org.springframework.boot.test.mock.mockito.MockBean;






@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

	
	@MockBean
	private  ClientController clientController;
	
	@Autowired
	private MockMvc mvc;
	
	Client client = new ClientTestDataBuilder().build();
	 
	@Test
	public void getAllClientAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/client")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());

	}
	 
	@Test
	public void getClientByIdAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/client/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	  }
	
	
	@Test
	public void updateClient() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/client/{id}", 2)
	      .content(asJsonString(client))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	  
	  
	}
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Test
	public void deleteClient() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders.delete("/client/{id}", 1) )
	        .andExpect(status().isOk());
	}
	
}
