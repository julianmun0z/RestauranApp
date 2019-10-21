package co.com.ceiba.restaurantapp.controllersTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.restaurantapp.TestDataBuilder.ReservationRequestTestDataBuilder;
import co.com.ceiba.restaurantapp.controllers.ClientController;
import co.com.ceiba.restaurantapp.controllers.ReservationRequestController;
import co.com.ceiba.restaurantapp.dto.ReservationRequest;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(ReservationRequestController.class)
public class ReservationRequestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	ReservationRequest reservationRequest = new ReservationRequestTestDataBuilder().build();
	
	@Test 
	public void createReservationAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .post("/fullreservation")
	      .contentType(MediaType.APPLICATION_JSON_UTF8)
          .content(objectMapper.writeValueAsString(reservationRequest)))
  		.andExpect(status().isOk());
	}
	 

}
