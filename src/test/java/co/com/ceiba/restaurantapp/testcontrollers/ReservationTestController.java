package co.com.ceiba.restaurantapp.testcontrollers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.ceiba.restaurantapp.dominio.ReservationDto;
import co.com.ceiba.restaurantapp.persistencia.entities.ReservationEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservationTestController {

	@Deprecated
	private static final Date RESERVATIONDATE = new Date(2019-1900,8,24);
	private static final int NUMBERPEOPLE = 5;
	private static final boolean DECOR = false;
	
	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	ReservationDto reservationDto = new ReservationDto();
	
	@InjectMocks
	ReservationEntity reservationEntity = new ReservationEntity();
	
	@Test
	public void createReservation() throws Exception
	{
		
		reservationDto.setReservationDate(RESERVATIONDATE);
		reservationDto.setNumberPeople(NUMBERPEOPLE);
		reservationDto.setDecor(DECOR);
		reservationDto.setReservationDate(reservationDto.getReservationDate());
		reservationDto.setNumberPeople(reservationDto.getNumberPeople());
		reservationEntity.setDecor(reservationDto.isDecor());
		
		
	}
	
	@Test
	public void getReservation() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/reservation")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());  
	}
	
	
	@Test
	public void getReservationId() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/reservation/{id}", 104)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void updateBill() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/reservation/{id}", 2)
	      .content(asJsonString(reservationEntity))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON));
}

	private byte[] asJsonString(ReservationEntity reservationEntity2) {
		// TODO Auto-generated method stub
		return null;
	}
}
