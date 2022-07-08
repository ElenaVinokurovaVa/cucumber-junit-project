
Feature: Etsy Search Functionality Title Verification (without parameterization)
  user should be able to search for an item


  Background:
    Given User is on Etsy main page

  Scenario: Etsy Search Functionality Title Verification
    When User search for Wooden spoon
    And User click search button
    Then User should see Wooden spoon in title

  Scenario: Etsy Search Functionality Title Verification
    When User search for "Wooden spoon"
    And User click search button
    Then User should see "Wooden spoon" in title