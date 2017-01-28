Feature: Create new client
  Scenario: The nurse should be able to register a new client
    Given nurse login to clinic site
    When go to New Client page
    Then create new client
    And client should be in the Client List