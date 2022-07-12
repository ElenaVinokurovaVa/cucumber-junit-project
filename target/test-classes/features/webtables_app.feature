Feature: Login
  User Story: as user I should be able to log in and see orders word in the url
  Background:
    Given User is on web table login page
  @webtables_login
  Scenario: User should login with valid credentials
    When User enters username "Test"
    And  User enters password "Tester"
    And  User clicks on login button
    Then User should see url contains word orders

   @webtables_login
   Scenario: positive login Scenario
     When User enters username "Test" and password "Tester" and clicks login
     Then User should see url contains word orders

  @webtables_login
  Scenario: map data table practice
    When User enters below credentials
    |username| Test|
    |password| Tester|
    Then User should see url contains word orders

