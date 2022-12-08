package api.controllers;

import api.ApiClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpBinApiController extends ApiClient {

    public Response getHttpBinEndpoint() {
        buildRequestSpec();
        return RestAssured.given(reqSpec())
                .log().all()
                .get("https://httpbin.org/get")
                .then()
                .log().all().extract().response();
    }

    public Response postDelayHttpBinEndpoint(int delay) {
        buildRequestSpec();
        return RestAssured.given(reqSpec())
                .log().all()
                .post("https://httpbin.org/delay/%s".formatted(delay))
                .then()
                .log().all().extract().response();
    }
}
