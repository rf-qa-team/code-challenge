package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.common.net.InetAddresses;
import io.restassured.response.Response;
import model.httpbin.get.GETResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

public class GETSteps {

    private HttpBinApiController httpBinApiController;


    @Given("a request to GET HttpBin data is requested")
    public void getHttpBinData() {
        // Initialize variables
        httpBinApiController = new HttpBinApiController();

        // Using the HttpBinApiController, hit the endpoint
        Response getResponse = httpBinApiController.getHttpBinEndpoint();

        // Store the get response in a thread to validate the content in other steps
        DATA_DUMP_COM.get().setResponse(getResponse);
        DATA_DUMP_COM.get().setGetResponse(getResponse.as(GETResponse.class));
    }

    @Then("GetResponse [args] are empty")
    public void getResponseArgsAreEmpty() {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getArgs(), aMapWithSize(0));
    }

    @Then("GetResponse [url] is equal to {string}")
    public void getResponseUrlIsEqualTo(String url) {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getUrl(), equalTo(url));
    }


    @Then("GetResponse [origin] is IP address")
    public void getResponseOriginIsIPAddress() {
        assertThat("Origin should be IP address",
                InetAddresses.isInetAddress(DATA_DUMP_COM.get().getGetResponse().getOrigin()));
    }

    @Then("GetResponse -> Headers [Accept] is {string}")
    public void getResponseHeadersAcceptIs(String accept) {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getAccept(), equalTo(accept));
    }

    @Then("GetResponse -> Headers [Accept-Encoding] is {string}")
    public void getResponseHeadersAcceptEncodingIs(String acceptEncoding) {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getAcceptEncoding(), equalTo(acceptEncoding));
    }

    @Then("GetResponse -> Headers [Content-Type] is {string}")
    public void getResponseHeadersContentTypeIs(String contentType) {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getContentType(), equalTo(contentType));
    }

    @Then("GetResponse -> Headers [User-Agent] is not empty")
    public void getResponseHeadersUserAgentIsNotEmpty() {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getUserAgent(), not(emptyOrNullString()));
    }

    @Then("GetResponse -> Headers [X-Amzn-Trace-Id] is not empty")
    public void getResponseHeadersXAmznTraceIdIsNotEmpty() {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getXAmznTraceId(), not(emptyOrNullString()));
    }

    @Then("GetResponse -> Headers [Host] is {string}")
    public void getResponseHeadersHostIs(String host) {
        assertThat(DATA_DUMP_COM.get().getGetResponse().getHeaders().getHost(), equalTo(host));
    }
}
