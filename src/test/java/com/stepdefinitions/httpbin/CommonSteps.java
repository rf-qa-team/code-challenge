package com.stepdefinitions.httpbin;

import io.cucumber.java.en.Then;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

public class CommonSteps {

    @Then("response status code is {int}")
    public void verifyStatusCodeIs(int code) {
        DATA_DUMP_COM.get().getResponse().then().statusCode(code);
    }

    @Then("response has delay time {long} seconds")
    public void postDelayResponseHasDelayTimeActualDelaySeconds(long timeInSeconds) {
        assertThat(DATA_DUMP_COM.get().getResponse().getTimeIn(SECONDS),
                allOf(greaterThanOrEqualTo(timeInSeconds),
                        // to cover possible network delay
                        lessThanOrEqualTo(timeInSeconds + 1)));
    }

}
