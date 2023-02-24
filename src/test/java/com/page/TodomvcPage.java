package com.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static util.webdriver.BasePageActions.*;

public class TodomvcPage {
	private static final String URL = "https://todomvc.com/examples/react/#/";

	@FindBy(css = "header>h1")
	private SelenideElement header;
	@FindBy(css = "input.toggle[type='checkbox']")
	private SelenideElement checkbox;
	@FindBy(css = "input.new-todo")
	private SelenideElement newTodoInput;
	@FindBy(css = "ul.todo-list>li")
	private ElementsCollection todoList;
	@FindBy(css = "ul.todo-list>li.editing>input.edit")
	private SelenideElement todoListInput;
	@FindBy(css = "button.destroy")
	private SelenideElement xButton;
	@FindBy(css = "ul.todo-list>li.completed")
	private ElementsCollection completedTodoList;
	@FindBy(css = "a[href='#/active']")
	private SelenideElement activeLink;
	@FindBy(css = "button.clear-completed")
	private SelenideElement clearCompletedButton;

	public void openTodomvcPage() {
		openUrl(URL);
		header.shouldHave(text("todos"));
	}

	public void createNewTodoItem(String todoText) {
		setDataToField(newTodoInput, todoText, true);
	}

	public void deleteOneTodoItem() {
		clickOnElement(todoList.first());
		clickOnElement(xButton);
	}

	public void checkOneTodoItem() {
		clickOnElement(todoList.first());
		clickOnElement(checkbox);
	}

	public void clickActiveLink() {
		clickOnElement(activeLink);
	}

	public void clickClearCompletedButton() {
		clickOnElement(clearCompletedButton);
	}

	public String getLastTodoText() {
		return todoList.last().getText();
	}

	public void editOneTodoItem(String todoText) {
		clickOnElement(todoList.first());
		$("ul.todo-list>li").doubleClick();
		setDataToField(todoListInput, todoText, true);
	}

	public int getTodoListCount() {
		return todoList.size();
	}

	public int getCompletedTodoListCount() {
		return completedTodoList.size();
	}

	public String getFirstCompletedTodoItemTextStyle(String propertyName) {
		return completedTodoList.first().find("div>label").getCssValue(propertyName);
	}
}