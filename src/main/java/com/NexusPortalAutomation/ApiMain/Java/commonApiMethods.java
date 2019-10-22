package com.NexusPortalAutomation.ApiMain.Java;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.net.HttpURLConnection;

import org.hamcrest.core.Is;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class commonApiMethods {

    public static String keycloakurl = "http://localhost:8080";
    public static String apiserverurl = "http://localhost:3000";

    /// @Test
    public static String getToken() {

	String url = keycloakurl + "/auth/realms/NexusPortal/protocol/openid-connect/token";

	Response response = given().auth().preemptive().basic("NexusPortal", url)
		.contentType("application/x-www-form-urlencoded").log().all().formParam("grant_type", "password")
		.formParam("username", "Admin").formParam("password", "Admin2019").when().post(url);

	JSONObject jsonObject = new JSONObject(response.getBody().asString());
	String accessToken = jsonObject.get("access_token").toString();
	String tokenType = jsonObject.get("token_type").toString();

	int responseCode = response.statusCode();

	if (HttpURLConnection.HTTP_OK == responseCode) {

	    return accessToken;
	} else {
	    String msg = "Access token retrieve failed. Http response code=" + responseCode;
	    System.out.println(msg);
	    throw new RuntimeException(msg);
	}

    }

    // @Test
    public static void isValidCustomercanmovein(String customerId, String locationId, String date, boolean response) {

	String url = apiserverurl + "/api/v1/defaultCustomer/isValidMoveInCustomer?CustomerId=" + customerId
		+ "&LocationId=" + locationId + "&SchdDateTime=" + date + "&SchdTime=00:00:00";
	String token = getToken();
	System.out.println(token);
	ValidatableResponse apiresponse = given()
		.headers("Authorization", "Bearer " + token, "Content-Type", ContentType.JSON, "Accept",
			ContentType.JSON)
		.when().get(url).then().assertThat().body("result.IsAllowed[0]", Is.is(response)).log().all();
    }

    // @Test
    public static void getaccountbalancesInvalidCustomer(String customerId, String locationId, String date,
	    String result, String Message) {

	String url = apiserverurl + "/api/v1/accountBalance/getAccountBalances?LocationId=" + locationId
		+ "&CustomerId=" + customerId + "&UserDate=" + date + "";
	String token = getToken();
	System.out.println(token);
	ValidatableResponse response = given()
		.headers("Authorization", "Bearer " + token, "Content-Type", ContentType.JSON, "Accept",
			ContentType.JSON)
		.when().when().get(url).then().assertThat().body("result.Success[0]", equalTo(result)).log().all().and()
		.assertThat().body("result.Message[0]", equalTo(Message)).log().all();
	System.out.println(url);
	System.out.println(response.toString());
    }

    // http://localhost:3000/api/v1/createServiceOrderAction

}
