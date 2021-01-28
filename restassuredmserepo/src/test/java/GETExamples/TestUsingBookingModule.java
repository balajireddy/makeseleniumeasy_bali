package GETExamples;

import org.testng.annotations.Test;

public class TestUsingBookingModule {
	
	@Test
	public void verifyBookingCount()
	{
		BookingModule bm = new BookingModule();
		bm.getBookingSpecWithBaseURI()
		.createBooking()
		.verifyCount(10);
	}

}
