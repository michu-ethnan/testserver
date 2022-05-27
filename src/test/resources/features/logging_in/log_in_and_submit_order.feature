Feature: Log in and submit order

  A customer should be able to log in and then submit order.

  Scenario: Login and order

    Given that Sven has a product in the minicart
    When he logs in
    And he orders a "mug" using courier delivery and transfer
    Then he should see that the order was made