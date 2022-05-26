Feature: Close cart

  A customer should be able to close the cart.

  Scenario: Close mini cart
    Given that Caleb opens minicart with a mug
    When he closes the cart
    Then he should see "login button text"

