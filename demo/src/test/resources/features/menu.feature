Feature: Greggs Menu Categories
  As a customer
  I want to browse different menu categories
  So that I can choose items to order

  Background:
    Given I am on the Greggs menu page

@allfactors
  Scenario Outline: View items in a menu category
    When I select the "<Category>" category
    Then I should see a list of "<ExpectedItems>"

    Examples:
      | Category                | ExpectedItems       |
      | Breakfast               | Breakfast           |
      | Savouries & Bakes       | Savouries & Bakes   |
      | Drinks & Snacks         | Drinks & Snacks     |
      | Sandwiches & Salads     | Sandwiches & Salads |
      | Sweet Treats            | Sweet Treats        |
      | Hot Food                | Hot Food            |

@topmenu
Scenario: view items
    When i check top menu
    Then click on list 
