package base;

import org.openqa.selenium.interactions.Actions;

import entities.Booking;

public class Test {

	@org.testng.annotations.Test
	public void demo() {
		Booking.builder().firstname("de").lastname("tt").depositpaid(false).build();
		Actions act= new Actions(null);
	}

}
