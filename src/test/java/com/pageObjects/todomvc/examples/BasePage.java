package com.pageObjects.todomvc.examples;

import util.webdriver.BasePageActions;

public class BasePage {

    private String url = "https://todomvc.com/examples/react/#/";

    public void openToDoMVCUrl() {
        BasePageActions.openUrl(url);
    }
}
