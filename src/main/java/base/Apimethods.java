package base;

import entities.AuthBody;
import entities.Booking;
import io.restassured.response.Response;

public interface Apimethods {

   public Response createToken(AuthBody authBody);
   public Response createBooking(Booking booking);
   public Response getBooking(String id);
   public Response getBooking();
   public Response updateBooking(Booking booking, String id);
   public Response deleteBooking(String bookingId);
   public Response deleteBooking();

}
