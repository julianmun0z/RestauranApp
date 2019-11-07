package co.com.ceiba.restaurantapp.controllersTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationRequestTestDataBuilder;
import co.com.ceiba.restaurantapp.controllers.ReservationRequestController;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;


@RunWith(SpringRunner.class)
@WebMvcTest(ReservationRequestController.class)
public class ReservationRequestControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	
	@MockBean
	private  ReservationRequestController reservationRequestController;
	
	ReservationRequest reservationRequest = new ReservationRequestTestDataBuilder().build();
	
	@Test
	public void createReservationAPI() throws Exception
	{
		
	  mvc.perform( MockMvcRequestBuilders
	      .post("/reservationrequest")
	      .content(asJsonString(reservationRequest)) 
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
	public void getAllReservation() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/reservationrequest")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void getReservationById() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/reservationrequest/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	  }
	
	@Test
	public void updateEmployeeAPI() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/reservationrequest/{id}",1)
	      .content(asJsonString(reservationRequest)) 
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	 
	}
	
	@Test
	public void deleteClient() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders.delete("/reservationrequest/{id}",1) )
	        .andExpect(status().isOk());
	}
}

