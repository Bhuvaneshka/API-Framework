package base;

import entities.AuthBody;
import entities.AuthBodyRes;
import entities.Booking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiMethodsImpl implements Apimethods {

	private final String BASE_URL = "https://restful-booker.herokuapp.com";
	
	// Create Token
	public Response createToken(AuthBody authBody) {
		Response res =  RestAssured.given().baseUri(BASE_URL)
				.basePath("auth")
				.contentType(ContentType.JSON).
				 body(authBody).log()
				.all(true).post();
//				.then().log().all().extract().response();
		res.body().as(AuthBodyRes.class);
		return res;
	}

	// Create Booking
	public Response createBooking(Booking booking) {
		return RestAssured.given().baseUri(BASE_URL).basePath("booking")
				.contentType(ContentType.JSON)
				.body(booking).log().all(true)
				.post();
	}

	//Get booking based on ID
	public Response getBooking(String id) {
		return RestAssured.given().baseUri(BASE_URL).basePath("booking")
				.contentType(ContentType.JSON)
				.log().all(true)
				.post(id);
	}

	//Get booking
	public Response getBooking() {
		return RestAssured.given().baseUri(BASE_URL).basePath("booking")
				.contentType(ContentType.JSON).get();
	}

	//Update Booking
	public Response updateBooking(Booking booking, String id) {
		return RestAssured.given().baseUri(BASE_URL).basePath("booking")
				.contentType(ContentType.JSON)
				.body(booking).log()
				.all(true).put(id);
	}

	//Delete Booking with ID
	public Response deleteBooking(String bookingId) {
		return RestAssured.given().baseUri(BASE_URL).basePath("booking")
				.contentType(ContentType.JSON)
				.log()
				.all(true).delete(bookingId);
	}
	//Delete Booking
		public Response deleteBooking( ) {
			return RestAssured.given().baseUri(BASE_URL).basePath("booking")
					.contentType(ContentType.JSON).log()
					.all(true).post();
		}

}
