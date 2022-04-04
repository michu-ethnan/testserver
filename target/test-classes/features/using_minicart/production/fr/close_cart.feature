Feature: Close cart FR

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a Jardin on FR
    When he closes the cart
    Then he should see "login button text_FR"

