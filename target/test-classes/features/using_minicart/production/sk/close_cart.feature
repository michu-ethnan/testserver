Feature: Close cart SK

  A customer should be able to close the cart.

  Scenario: Should be able to
    Given that Caleb opens minicart with a hrnček on SK
    When he closes the cart
    Then he should see "login button text_SK"

