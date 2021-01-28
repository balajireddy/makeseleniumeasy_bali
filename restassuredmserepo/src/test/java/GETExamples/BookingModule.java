package GETExamples;

import java.util.List;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BookingModule {
	
	
	RequestSpecification request ;
	Response response;
	int statusCode;
	String body;
	List<BookingPojo> bookingPojo;
	
	public BookingModule getBookingSpecWithBaseURI()
	{
		request =  RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking");
		return this;
	}
	
	public BookingModule createBooking()
	{
		response = request.when().get();
		statusCode= response.statusCode();
		body = response.getBody().asString();
		bookingPojo = response.as(new TypeRef<List<BookingPojo>>() {
		});
		return this;
	}
	
	public BookingModule verifyCount(int count)
	{
		response.then().body("bookingid", Matchers.hasSize(10));
		return this;
	}

}
