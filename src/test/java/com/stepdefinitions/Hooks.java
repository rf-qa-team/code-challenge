package com.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

import static util.datastore.DataThreadLocals.DATA_DUMP_COM;

import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.Selenide;

/**
 * Hooks methods that will be run after each scenario/step.
 */
public class Hooks {

    WebDriver driver;
    /**
     * Example: will run this after scenario that has tag- "@test_tag".
     */
    @After("@test_tag")
    public void example() {


    }

    @After()
    public void tearDown() {
        Selenide.closeWebDriver();
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
