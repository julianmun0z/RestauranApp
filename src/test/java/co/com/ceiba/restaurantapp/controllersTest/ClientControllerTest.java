package co.com.ceiba.restaurantapp.controllersTest;




import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.ceiba.restaurantapp.controllers.ClientController;

;




@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class ClientControllerTest {

	
	@Autowired
	private MockMvc mvc;
	 
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
}
