package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.httpbin.GETResponse;
import model.httpbin.getObjects.Headers;
import org.testng.Assert;
import util.datastore.ComDataDump;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

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

    @Then("checking that the GET response for args part is correct")
    public void checkingThatTheGETResponseForArgsPartIsCorrect() {
        Assert.assertEquals(comDataDump.getGetResponse().getArgs().size(), 0);
    }

    @And("checking that the GET response for headers part is correct")
    public void checkingThatTheGETResponseForHeadersPartIsCorrect() {
        Headers headersData = comDataDump.getGetResponse().getHeaders();
        Assert.assertTrue(headersData.getAccept().contains("application/json"));
        Assert.assertTrue(headersData.getAcceptEncoding().contains("gzip,deflate"));
        Assert.assertEquals(headersData.getContentType(), "application/json");
        Assert.assertEquals(headersData.getHost(), "httpbin.org");
        Assert.assertTrue(headersData.getUserAgent().contains("Apache-HttpClient"));
        Assert.assertFalse(headersData.getXAmznTraceId().isEmpty());
    }

    @And("checking that the GET response for origin part is correct")
    public void checkingThatTheGETResponseForOriginPartIsCorrect() {
        Assert.assertTrue(comDataDump.getGetResponse().getOrigin().matches("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$"));
    }

    @And("checking that the GET response for url part is correct")
    public void checkingThatTheGETResponseForUrlPartIsCorrect() {
        try {
            new URL(comDataDump.getGetResponse().getUrl()).toURI();
            Assert.assertTrue(true);
        } catch (MalformedURLException | URISyntaxException e) {
            Assert.fail();
        }
    }
}