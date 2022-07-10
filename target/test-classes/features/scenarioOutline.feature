@scanarioOutline
Feature: Simple examples about Scenario Outline
  Scenario Outline: Menu Options for <userType>
    Given user is on the login page
    When user enters the "<userType>" information
    Then user should be able to see following modules
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |