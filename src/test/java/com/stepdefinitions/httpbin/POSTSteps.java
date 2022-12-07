package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.httpbin.POSTResponse;
import util.datastore.ComDataDump;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoUnit.SECONDS;

public class POSTSteps {
    private HttpBinApiController httpBinApiController;
    private final ComDataDump comDataDump = new ComDataDump();

    @Given("a POST request to delay {int} is sent")
    public void aPOSTRequestToDelayIsSent(int seconds) {
        // Initialize variables
        httpBinApiController = new HttpBinApiController();

        // Using the HttpBinApiController, hit the endpoint
        comDataDump.setBefore(Instant.now());
        POSTResponse postResponse = httpBinApiController.POSTHttpBinEndpoint(seconds);
        comDataDump.setAfter(Instant.now());

        // Store the get response in a thread to validate the content in other steps
        comDataDump.setPostResponse(postResponse);
    }

    @Then("verify the delay response delay of {int} is accurate")
    public void verifyTheDelayResponseDelayOfSecondsIsAccurate(int seconds) {
        Long delay = comDataDump.getBefore().until(comDataDump.getAfter(), SECONDS);
        assert (delay >= seconds && delay < seconds + 5);
    }
    @And("verify the delay response data is okay")
    public void verifyTheDelayResponseDataIsOkay() {
        assert comDataDump.getPostResponse().getArgs().isEmpty();
        assert  (comDataDump.getPostResponse().getHeaders().get("Accept").toString() == "*/*");
        assert  (comDataDump.getPostResponse().getHeaders().get("Accept-Encoding").toString().contains("gzip") &&
                (comDataDump.getPostResponse().getHeaders().get("Accept-Encoding").toString().contains("deflate")));
        assert  (comDataDump.getPostResponse().getHeaders().get("Host").toString() == "httpbin.org");
        assert  (comDataDump.getPostResponse().getHeaders().get("User-Agent").toString().contains("Apache-HttpClient"));
        assert  (!comDataDump.getPostResponse().getHeaders().get("X-Amzn-Trace-Id").isNull());
        Pattern ipAddress = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        assert ipAddress.matcher(comDataDump.getPostResponse().getOrigin()).matches();
        try {
            new URL(comDataDump.getPostResponse().getUrl()).toURI();
            assert true;
        } catch (MalformedURLException e) {
            assert false;
        } catch (URISyntaxException e) {
            assert false;
        }
    }

}
