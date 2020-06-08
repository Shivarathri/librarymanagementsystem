
Feature: UserRegistration

  Scenario Outline: 
    Given User is on Registration page
    When User enters  <userName>,<email>,<password>,<mobile>,<role>
    Then User should be <status>

    Examples: 
      | userName | email              | password       | mobile     | role      | status       |
      | "Shiva"  | "ammulu@gmail.com" | "Password@123" | 7330300950 | "Student" | "registered" |
