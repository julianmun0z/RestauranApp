package co.com.ceiba.restaurantapp.controllersTest;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationRequestTestDataBuilder;
import co.com.ceiba.restaurantapp.controllers.ReservationRequestController;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservationRequestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	
	ReservationRequest reservationRequest = new ReservationRequestTestDataBuilder().build();
	
	@Test
	public void createEmployeeAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .post("/fullreservation")
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
}
