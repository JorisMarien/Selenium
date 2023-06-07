Feature: Am I logged in?

  Scenario Outline: login
    Given I am on the login page
    When I type "<username>" and "<password>"
    Then There is a green banner with success

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |