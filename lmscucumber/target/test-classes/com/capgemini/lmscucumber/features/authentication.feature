@book
Feature: UserLogin

  Scenario Outline: Admin is able to add the book
    When Admin give "prasant@gmail.com", "Password@123"
    Then Admin logged in
    And Clicking on the Admin
    Then Admin adds book
    When Admin enter  <bookName>,<author>,<category>,<publisher>
    Then Book <status>
    And Admin should be Logout

    Examples: 
      | bookName | author  | category      | publisher     | status          |
      | "Java"   | "James" | "Programming" | "microsystem" | "Book is added" |

  Scenario: User Requesting the book
    When User enters   "ravi@gmail.com" , "Password@123"
    Then User should be logged in
    Then User click on the Student Dropdown Field
    And User click on Request book
    Then User click on the Request
    And User should be Logout

  Scenario: Admin issueing the book
    When Admin enter the username "prasant@gmail.com"
    And enters the password "Password@123"
    Then Admin sholud be in Logged in
    And Admin click on admin dropdown
    Then Admin click on the show request
    And Admin click on the ISSUE
    Then Admin Should be Logged out

  Scenario: User returning the book
    When User enter the username "ravi@gmail.com"
    And enter the password  "Password@123"
    Then User Should be LOgged in
    And User click on the Student
    Then User click on the Return Book
    And User Should be Log Out
