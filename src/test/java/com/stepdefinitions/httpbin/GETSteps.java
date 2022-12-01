package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import model.httpbin.GETResponse;
import util.datastore.ComDataDump;

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


}
