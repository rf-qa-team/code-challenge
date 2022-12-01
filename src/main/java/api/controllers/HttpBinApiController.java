package api.controllers;

import api.ApiClient;
import io.restassured.RestAssured;
import model.httpbin.GETResponse;
import org.apache.http.HttpStatus;

public class HttpBinApiController extends ApiClient {

    public GETResponse getHttpBinEndpoint() {
        return RestAssured.given(reqSpec())
                .log().all()
                .get("https://httpbin.org/get")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(GETResponse.class);
    }
}
