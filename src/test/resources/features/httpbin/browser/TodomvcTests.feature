Feature: Basic todomvc features for tech interview

  Background: go to todomvc page with some initial setup actions
    Given I am a user of todomvc
    And I enter 5 todo items with description starting with "my TODO item"


  Scenario: verify new todo item appears last on my todo list
    When I create a new todo item with description of "test new item"
    Then it appears last on my todo list with description of "test new item"

# TODO: edit not working
  Scenario: verify todo item can be updated
    When I edit a todo item with description of "my new edited item"

  Scenario: verify delete a todo item
    When I delete a todo item using the red X button
    Then the todo item is removed from my todo list of 5 items

  Scenario: verify complete a todo item
    When I mark a todo item as completed
    Then it is marked with a green checkmark
    And it is crossed off my todo list with a Strikethrough

  Scenario: verify active list item
    Given I mark a todo item as completed
    When I click on the active link
    Then only Active todo items are shown

  Scenario: verify clear completed todo items
    Given I mark a todo item as completed
    When I click Clear completed button
    Then the todo item is removed from my todo list of 5 items