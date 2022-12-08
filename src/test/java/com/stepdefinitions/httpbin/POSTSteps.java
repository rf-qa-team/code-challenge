package com.stepdefinitions.httpbin;

import api.controllers.HttpBinApiController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.google.common.net.InetAddresses;
import io.restassured.response.Response;
import model.httpbin.post.POSTDelayResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

public class POSTSteps {
    private HttpBinApiController httpBinApiController;

    @Given("a request to POST delay HttpBin data with {int} is requested")
    public void postDelayHttpBinData(int delay) {
        httpBinApiController = new HttpBinApiController();
        Response response = httpBinApiController.postDelayHttpBinEndpoint(delay);
        DATA_DUMP_COM.get().setResponse(response);
        DATA_DUMP_COM.get().setPostDelayResponse(response.as(POSTDelayResponse.class));
    }

    @Then("POSTDelayResponse [args] are empty")
    public void getResponseArgsAreEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getArgs(), aMapWithSize(0));
    }

    @Then("POSTDelayResponse [url] is equal to {string}")
    public void getResponseUrlIsEqualTo(String url) {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getUrl(), equalTo(url));
    }


    @Then("POSTDelayResponse [origin] is IP address")
    public void getResponseOriginIsIPAddress() {
        assertThat("Origin should be IP address",
                InetAddresses.isInetAddress(DATA_DUMP_COM.get().getPostDelayResponse().getOrigin()));
    }

    @Then("POSTDelayResponse -> Headers [Accept] is {string}")
    public void getResponseHeadersAcceptIs(String accept) {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getAccept(), equalTo(accept));
    }

    @Then("POSTDelayResponse -> Headers [Accept-Encoding] is {string}")
    public void getResponseHeadersAcceptEncodingIs(String acceptEncoding) {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getAcceptEncoding(), equalTo(acceptEncoding));
    }

    @Then("POSTDelayResponse -> Headers [Content-Type] is {string}")
    public void getResponseHeadersContentTypeIs(String contentType) {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getContentType(), equalTo(contentType));
    }

    @Then("POSTDelayResponse -> Headers [User-Agent] is not empty")
    public void getResponseHeadersUserAgentIsNotEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getUserAgent(), not(emptyOrNullString()));
    }

    @Then("POSTDelayResponse -> Headers [X-Amzn-Trace-Id] is not empty")
    public void getResponseHeadersXAmznTraceIdIsNotEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getXAmznTraceId(), not(emptyOrNullString()));
    }

    @Then("POSTDelayResponse -> Headers [Host] is {string}")
    public void getResponseHeadersHostIs(String host) {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getHeaders().getHost(), equalTo(host));
    }

    @And("POSTDelayResponse [data] is empty")
    public void postDelayResponseDataIsEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getData(), emptyString());
    }

    @And("POSTDelayResponse [files] is empty")
    public void postDelayResponseFilesIsEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getFiles(), aMapWithSize(0));
    }

    @And("POSTDelayResponse [form] is empty")
    public void postDelayResponseFormIsEmpty() {
        assertThat(DATA_DUMP_COM.get().getPostDelayResponse().getForm(), aMapWithSize(0));
    }
}
