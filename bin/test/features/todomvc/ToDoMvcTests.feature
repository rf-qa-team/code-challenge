Feature: ToDoMVC Tests

    Background: this will run before each scenario
        Given I am a user of todomvc
        When I create a new todo item

    Scenario: Validate that a user can create a new to do list item
        Then it appears last on my todo list

    Scenario: Validate that items can be updated
        When I edit a todo item
        Then the todo item gets updated with the new changes

    Scenario: Validate that a user can remove an item from a todo list
        When I delete a todo item using the red X
        Then the todo item is removed from my todo list

    Scenario: Validate that a todo list item can be marked as completed
        When I mark a todo item as completed
        Then it is marked with a green check mark
        And it is crossed off my todo list with a Strikethrough

    Scenario: Validate that afer marking an item as complete that it does not show up in the todo items list
        Given I have marked a todo item as complete
        When I view the Active list
        Then only Active (Not Completed) todo items are shown

    Scenario: Validate that a completed todo item can be removed from the todo list
        Given I have marked a todo item as complete
        When I click “Clear Completed”
        Then the completed todo item is removed from my todo list
        And the todo item is moved to the Completed list