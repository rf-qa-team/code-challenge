package api.controllers;

import api.ApiClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.httpbin.GETResponse;
import org.apache.http.HttpStatus;

public class HttpBinApiController extends ApiClient {

    private final String BASE_URL = "https://httpbin.org/";

    public GETResponse getHttpBinEndpoint() {
        return RestAssured.given(generateReqSpecWithoutToken(BASE_URL))
                .basePath("get")
                .log().all()
                .get()
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(GETResponse.class);
    }

    public Response postHttpBinEndpoint(int delaySec) {
        return RestAssured.given(generateReqSpecWithoutToken(BASE_URL))
                .basePath(String.format("delay/%s", delaySec))
                .log().all()
                .post()
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();
    }
}