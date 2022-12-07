package api.controllers;

import api.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import model.httpbin.GETResponse;
import model.httpbin.POSTResponse;
import org.apache.http.HttpStatus;

public class HttpBinApiController extends ApiClient {

    public GETResponse getHttpBinEndpoint() {
        return RestAssured.get("https://httpbin.org/get")
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(GETResponse.class);
    }
    public POSTResponse POSTHttpBinEndpoint(Integer delay) {
        return RestAssured.post("https://httpbin.org/delay/"+delay)
                .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(POSTResponse.class);
    }
}
