@Ignore
Feature: Use ePoints

  A customer should be able to use their ePoints.

  Scenario: Should be able to

    Given that Edward is about to finalize his transaction using transfer
    When he adds ePoints
    Then he should see the discount

  Scenario: Should be able to

    Given that Edward is about to finalize his transaction using transfer
    When he adds ePoints
    And he hits the refresh button
    Then he should see the discount