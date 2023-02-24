package com.stepdefinitions.browser;

import com.page.TodomvcPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.page;

public class BasicActionSteps {
	private final TodomvcPage todomvcPage = page(TodomvcPage.class);

	@Given("I am a user of todomvc")
	public void i_am_a_user_of_todomvc() {
		todomvcPage.openTodomvcPage();
	}

	@And("I enter {int} todo items with description starting with {string}")
	public void i_enter_todo_items(int todoItems, String description) {
		for (int i = 0; i < todoItems; i++) {
			todomvcPage.createNewTodoItem(description + i);
		}
	}

	@When("I create a new todo item with description of {string}")
	public void i_create_a_new_todo_item_with_description_of(String description) {
		todomvcPage.createNewTodoItem(description);
	}

	@Then("it appears last on my todo list with description of {string}")
	public void it_appears_last_on_my_todo_list_with_description_of(String description) {
		String str = todomvcPage.getLastTodoText();
		Assert.assertEquals(str, description);
	}

	@When("I edit a todo item with description of {string}")
	public void i_edit_a_todo_item_with_description_of(String description) {
		todomvcPage.editOneTodoItem(description);
	}

	@When("I delete a todo item using the red X button")
	public void i_delete_a_todo_item_using_the_red_x_button() {
		todomvcPage.deleteOneTodoItem();
	}

	@Then("the todo item is removed from my todo list of {int} items")
	public void the_todo_item_is_removed_from_my_todo_list_of_items(int todoItems) {
		Assert.assertTrue(todoItems - todomvcPage.getTodoListCount() <= 1, "should have deleted one item");
	}

	@When("I mark a todo item as completed")
	public void i_mark_a_todo_item_as_completed() {
		todomvcPage.checkOneTodoItem();
	}

	@Then("it is marked with a green checkmark")
	public void it_is_marked_with_a_green_checkmark() {
		Assert.assertTrue(todomvcPage.getCompletedTodoListCount() >= 1, "should have marked completed");
	}

	@And("it is crossed off my todo list with a Strikethrough")
	public void it_is_crossed_off_my_todo_list_with_a_strikethrough() {
		Assert.assertEquals(todomvcPage.getFirstCompletedTodoItemTextStyle("text-decoration-line"), "line-through");
	}

	@When("I click on the active link")
	public void i_click_on_the_active_link() {
		todomvcPage.clickActiveLink();
	}

	@Then("only Active todo items are shown")
	public void only_Active_todo_items_are_shown() {
		Assert.assertEquals(todomvcPage.getCompletedTodoListCount(), 0);
	}

	@When("I click Clear completed button")
	public void i_click_Clear_completed_button() {
		todomvcPage.clickClearCompletedButton();
	}
}