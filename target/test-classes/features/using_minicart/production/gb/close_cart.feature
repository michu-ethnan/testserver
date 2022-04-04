Feature: Close cart GB

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a MUG on GB
    When he closes the cart
    Then he should see "login button text_GB"

