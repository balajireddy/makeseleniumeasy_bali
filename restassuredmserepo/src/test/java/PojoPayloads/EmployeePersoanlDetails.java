package PojoPayloads;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class EmployeePersoanlDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	LocalDate dateOfBirth;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
	LocalDate dateOfJoining;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
	LocalDate dateOfLeaving;
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public LocalDate getDateOfLeaving() {
		return dateOfLeaving;
	}
	public void setDateOfLeaving(LocalDate dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	
	

}
