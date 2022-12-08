package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import util.datastore.ComDataDump;

import java.util.concurrent.TimeUnit;

public class POSTSteps {
    private HttpBinApiController httpBinApiController;

    private ComDataDump comDataDump = new ComDataDump();
    private long delayTime;

    @Given("POST request with a delay of <{int}> seconds was sent")
    public void postRequestWithADelayOfSecondsWasSent(int delaySec) {
        // Initialize variables
        httpBinApiController = new HttpBinApiController();

        // Using the HttpBinApiController, hit the endpoint
        Response postResponse = httpBinApiController.postHttpBinEndpoint(delaySec);

        // Store the post response in a thread to validate the content in other steps
        comDataDump.setResponse(postResponse);
    }

    @When("receive daley time")
    public void receiveDaleyTime() {
        delayTime = comDataDump.getResponse().getTimeIn(TimeUnit.SECONDS);
    }

    @Then("request delay time in <{int}> second is correct")
    public void requestDelayTimeInSecondIsCorrect(int delaySec) {
        Assert.assertTrue(delayTime >= delaySec && delayTime < delaySec + 5);
    }
}