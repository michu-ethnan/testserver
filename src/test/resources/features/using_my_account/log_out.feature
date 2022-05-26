Feature: Logging out

  Customer should be able to log out.

  Scenario: Logging out

    Given that Lorna is logged into My Account
    When she attempts to log out
    Then she should see login button