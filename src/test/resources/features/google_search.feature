Feature: Google Search Functionality Title Verification
  User story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Background:
    Given User is on Google search page

  @smoke @googlesearch @ev
  Scenario: Search functionality result title verification
    When User types apple in the google search box and clicks enter
    Then User sees apple – Google Search is in the google title


  @googlesearch
  Scenario: Search functionality result title verification
    When User types "apple" in the google search box and clicks enter
    When User types "apple" in the facebook search box and clicks enter
    Then User sees "apple - Google Search" is in the google title