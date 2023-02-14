package com.pageObjects.todomvc.examples;

import static com.codeborne.selenide.Selenide.$;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;
import util.webdriver.BasePageActions;

public class ReactPage extends BasePage {

    @FindBy(className = "new-todo")
    public SelenideElement todoTextField;

    @FindBy(linkText = "All")
    public SelenideElement allBtn;

    @FindBy(linkText = "Active")
    public SelenideElement activeBtn;

    @FindBy(linkText = "Completed")
    public SelenideElement completedBtn;

    @FindBy(css = "button.destroy")
    public SelenideElement xBtn;

    @FindBy(className = "todo-list")
    public List<SelenideElement> todoList;

    @FindBy(className = "clear-completed")
    public SelenideElement clearCompletedBtn;

    public void clickOnTextField() {
        BasePageActions.clickOnElement(todoTextField);
    }

    public void enterTextInToDoField(String text) {
        BasePageActions.setDataToField(todoTextField, text);
    }

    public void pressReturnKeyOnTextField() {
        BasePageActions.pressReturnKey(todoTextField);
    }

    public void clickOnAllBtn() {
        BasePageActions.clickOnElement(allBtn);
    }

    public void clickOnActiveBtn() {
        BasePageActions.clickOnElement(activeBtn);
    }

    public void clickOnCompletedBtn() {
        BasePageActions.clickOnElement(completedBtn);
    }

    public void clickOnXBtn() {
        BasePageActions.click(xBtn);
    }

    public void clickOnClearCompletedBtn() {
        BasePageActions.clickOnElement(completedBtn);
    }

    public void clickOnCompletedRadioBtn() {
        BasePageActions.clickOnElement(completedBtn);
    }

    public void enterTextInToDoFieldAndReturn(String text) {
        clickOnTextField();
        enterTextInToDoField(text);
        pressReturnKeyOnTextField();
    }

    public String getLastListItem() {
        String lastItem = todoList.get(todoList.size() - 1).getText();

        return lastItem;
    }

    public String getValueOfListItem() {
        String lastItem = todoList.get(todoList.size() - 1).getText();

        return lastItem;
    }

    public boolean checkTextInList(String text) {

        String xpath = String.format("//*[contains(text(),'initially open')]", text);
        return todoList.contains(xpath);
    }

    public void editToDoItem(String oldValue, String newValue) {

        SelenideElement todoField = $(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        BasePageActions.doubleClickOnElementAndEnterText(todoField, newValue);
        
    }
}
