Feature: Am I logged in?
  Everybody wants to know if I am logged in

  Scenario: log in
    Given I am on the log in page
    When I typ the correct credentials
    Then there is a green banner with success