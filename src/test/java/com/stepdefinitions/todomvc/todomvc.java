package com.stepdefinitions.todomvc;

import com.pageObjects.todomvc.examples.BasePage;
import com.pageObjects.todomvc.examples.ReactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertThat;

import org.junit.Assert;

import static com.codeborne.selenide.Selenide.page;

public class todomvc {

    private ReactPage reactPage = page(ReactPage.class);
    private BasePage basePage = page(BasePage.class);

    @Given("I am a user of todomvc")
    public void iAmAUserOfTodomvc() throws Throwable {
        basePage.openToDoMVCUrl();
    }

    @When("I create a new todo item")
    public void iCreateANewTodoItem() {
        reactPage.enterTextInToDoFieldAndReturn("testing");
    }

    @When("I delete a todo item using the red X")
    public void I_delete_a_todo_item_using_the_red_X() {
        reactPage.clickOnXBtn();

    }

    @Then("the todo item gets updated with the new changes")
    public void the_todo_item_gets_updated_with_the_new_changes() {
        String newValue = reactPage.getValueOfListItem();
        Assert.assertEquals("testing1", newValue);
    }

    @When("I edit a todo item")
    public void I_edit_a_todo_item() {
        reactPage.editToDoItem("testing", "testing1234");
    }

    @Given("I have created a todo item")
    public void I_have_created_a_todo_item() {
        reactPage.enterTextInToDoFieldAndReturn("testing");
    }

    @Then("only Active \\(Not Completed) todo items are shown")
    public void only_Active_Not_Completed_todo_items_are_shown() {

    }

    @When("I view the Active list")
    public void I_view_the_Active_list() {
        reactPage.clickOnActiveBtn();
    }

    @Given("I have marked a todo item as complete")
    public void I_have_marked_a_todo_item_as_complete() {
        reactPage.clickOnCompletedRadioBtn();
    }

    @Then("it is crossed off my todo list with a Strikethrough")
    public void it_is_crossed_off_my_todo_list_with_a_Strikethrough() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("it is marked with a green check mark")
    public void it_is_marked_with_a_green_check_mark() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I mark a todo item as completed")
    public void I_mark_a_todo_item_as_completed() {
        reactPage.clickOnCompletedRadioBtn();
    }

    @Then("the todo item is moved to the Completed list")
    public void the_todo_item_is_moved_to_the_Completed_list() {
        reactPage.clickOnCompletedRadioBtn();
        Assert.assertEquals(reactPage, basePage);
    }

    @Then("the completed todo item is removed from my todo list")
    public void the_completed_todo_item_is_removed_from_my_todo_list() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click “Clear Completed”")
    public void I_click_Clear_Completed() {
        reactPage.clickOnClearCompletedBtn();
    }

    @Then("the todo item is removed from my todo list")
    public void the_todo_item_is_removed_from_my_todo_list() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("it appears last on my todo list")
    public void it_appears_last_on_my_todo_list() {
        String lastItem = reactPage.getLastListItem();
        Assert.assertEquals("testing", lastItem);
    }
    
}
