package PojoPayloads;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class UsgaeOfEmployeePersonalDetails {
	
	@Test
	public void useDates() throws JsonProcessingException
	{
		EmployeePersoanlDetails employeePersoanlDetails = new EmployeePersoanlDetails();
//		employeePersoanlDetails.setDateOfBirth(LocalDate.parse("1990-11-11"));
//		employeePersoanlDetails.setDateOfJoining(LocalDate.parse("2018-01-27"));
//		employeePersoanlDetails.setDateOfLeaving(LocalDate.parse("2019-11-30"));
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
        //System.out.println(formatter.format(dt)); 
        
		employeePersoanlDetails.setDateOfBirth(LocalDate.of(1990,11,11));
		employeePersoanlDetails.setDateOfJoining(LocalDate.of(2018,01,03));
		employeePersoanlDetails.setDateOfLeaving(LocalDate.of(2019,04,17));
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.registerModule(new JavaTimeModule());
		String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePersoanlDetails);
		System.out.println(convertedJson);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		EmployeePersoanlDetails ed = objectMapper.readValue(convertedJson, EmployeePersoanlDetails.class);
		//Assert.assertEquals(employeePersoanlDetails, ed);
		Assert.assertEquals(ed.getDateOfBirth(),employeePersoanlDetails.getDateOfBirth());
		System.out.println(ed.getDateOfBirth());
		System.out.println(employeePersoanlDetails.getDateOfBirth());
	}

}
