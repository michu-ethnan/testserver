Feature: Close cart IT

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a Giardino on IT
    When he closes the cart
    Then he should see "login button text_IT"

