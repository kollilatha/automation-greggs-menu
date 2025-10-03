@regression
Feature: Greggs Website Performance Testing

Background:
    Given I am on the Greggs menu page

  Scenario: Measure page load time
    Then page should load within 3 seconds

