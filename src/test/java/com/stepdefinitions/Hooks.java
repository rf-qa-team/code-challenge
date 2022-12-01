package com.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

/**
 * Hooks methods that will be run after each scenario/step.
 */
public class Hooks {
    /**
     * Example: will run this after scenario that has tag- "@test_tag".
     */
    @After("@test_tag")
    public void example() {


    }


    /**
     * Will add the latest response body and code if step failed.
     */
    @After
    public void afterFailedScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            Response response = DATA_DUMP_COM.get().getResponse();
            Allure.addAttachment("Response body: ", response.getBody().asString());
            Allure.addAttachment("Response code: ", String.valueOf(response.getStatusCode()));
        }
    }
}
