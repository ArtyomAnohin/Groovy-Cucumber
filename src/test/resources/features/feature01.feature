Feature: Calculator
  Calculator should be able to add two numbers
  Calculator should be able to subtract two numbers
  Calculator should be able to multiplication two numbers
  Calculator should be able to division two numbers

  Scenario: Calculator should be able to add two numbers
    Given add 2 and 2
    When calculator run add
    Then result should be 4

  Scenario: Calculator should be able to subtract two numbers
    Given add 2 and 2
    When calculator run subtract
    Then result should be 0

  Scenario: Calculator should be able to multiplication two numbers
    Given add 2 and 2
    When calculator run multiplication
    Then result should be 4

  Scenario: Calculator should be able to division two numbers
    Given add 2 and 2
    When calculator run division
    Then result should be 0