package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import model.httpbin.GETResponse;
import model.httpbin.getObjects.Headers;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import util.datastore.ComDataDump;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.regex.Pattern;

public class GETSteps {

    private HttpBinApiController httpBinApiController;

    private final ComDataDump comDataDump = new ComDataDump();

    @Given("a request to GET HttpBin data is requested")
    public void getHttpBinData() {
        // Initialize variables
        httpBinApiController = new HttpBinApiController();

        // Using the HttpBinApiController, hit the endpoint
        GETResponse getResponse = httpBinApiController.getHttpBinEndpoint();

        // Store the get response in a thread to validate the content in other steps
        comDataDump.setGetResponse(getResponse);
    }

    @Then("verify the GET HttpBin response args are ok")
    public void verifyTheGETHttpBinResponseArgsAreOk() {
        assert comDataDump.getGetResponse().getArgs().isEmpty();
    }

    @And("verify the GET HttpBin response headers are ok")
    public void verifyTheGETHttpBinResponseHeadersAreOk() {
        assert  (comDataDump.getGetResponse().getHeaders().get("Accept").toString() == "*/*");
        assert  (comDataDump.getGetResponse().getHeaders().get("Accept-Encoding").toString().contains("gzip") &&
                (comDataDump.getGetResponse().getHeaders().get("Accept-Encoding").toString().contains("deflate")));
        assert  (comDataDump.getGetResponse().getHeaders().get("Host").toString() == "httpbin.org");
        assert  (comDataDump.getGetResponse().getHeaders().get("User-Agent").toString().contains("Apache-HttpClient"));
        assert  (!comDataDump.getGetResponse().getHeaders().get("X-Amzn-Trace-Id").isNull());

    }

    @And("verify the GET HttpBin response origin is ok")
    public void verifyTheGETHttpBinResponseOriginIsOk() {
        Pattern ipAddress = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        assert ipAddress.matcher(comDataDump.getGetResponse().getOrigin()).matches();
    }

    @And("verify the GET HttpBin response url is ok")
    public void verifyTheGETHttpBinResponseUrlIsOk() {
        try {
            new URL(comDataDump.getGetResponse().getUrl()).toURI();
            assert true;
        } catch (MalformedURLException e) {
            assert false;
        } catch (URISyntaxException e) {
            assert false;
        }
    }
}
