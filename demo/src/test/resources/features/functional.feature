@smoke
Feature: Greggs Menu Page Functional Verification

Background:
    Given I am on the Greggs menu page

@category
  Scenario: Verify category selection updates products
    When I select "Breakfast" category
    Then only breakfast items should be displayed
    

@functionality
  Scenario: Verify search functionality
    When I search for "Sausage Roll"
    Then the search results should include "Sausage Roll"
