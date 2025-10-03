Feature: Greggs Menu Categories
  As a customer
  I want to filter a menu category
  So that I can choose items to order

Background:
    Given I am on the Greggs menu page
@menufilter
Scenario: Select filter icon on the menu page
    When I click on filter menu pop up should be displayed
    Then from selected category I should select items
