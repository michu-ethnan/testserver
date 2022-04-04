Feature: Close cart ES

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a Jardín on ES
    When he closes the cart
    Then he should see "login button text_ES"

