Feature: Close cart PL

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a mug on PL
    When he closes the cart
    Then he should see "login button text"

