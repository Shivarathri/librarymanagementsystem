@admin
Feature: Admin Book Services

  Background: 
    Given Admin is on login page
    When Admin gives "prasant@gmail.com", "Password@123"
    Then Admin is logged in
    And Click on the Admin

  Scenario Outline: Admin is able to add the book
    Given Admin is adding book
    When Admin enters  <bookName>,<author>,<category>,<publisher>
    Then Book should be <status>

    Examples: 
      | bookName | author  | category      | publisher     | status          |
      | "jdbc"   | "James" | "Programming" | "microsystem" | "Book is added" |

  Scenario Outline: Admin is able to update the book
    Given Admin is updating book
    When Admin enters updated values <bookName>,<author>,<category>,<publisher>
    Then Book will be <status>
    And Admin is deleting book

    Examples: 
      | bookName | author | category       | publisher | status    |
      | "jjjjj"  | "jjjj" | "connectivity" | "rahul"   | "updated" |
