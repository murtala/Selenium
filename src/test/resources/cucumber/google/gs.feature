Feature: Google Search
Scenario: Finding some cheese
  Given I am on Google
  When I search for "Cheese!"
  Then the page title should start with "cheese"