Feature: Add product to cart and order-2

  A customer should be able to add a product to cart and order it.

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using courier delivery
    And he enters shipping address as person
    And he attempts to pay using card
    And he attempts to use sandbox
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using courier delivery
    And he enters shipping address as person
    And he attempts to pay using pickup
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using courier delivery
    And he enters shipping address as company
    And he attempts to pay using card
    And he attempts to use sandbox
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using courier delivery
    And he enters shipping address as company
    And he attempts to pay using pickup
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using courier delivery
    And he attempts to pay using pickup
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using pickup delivery
    And he attempts to pay using card
    And he attempts to use sandbox
    Then the order should be placed

  Scenario: Should be able to
    Given that Adam adds product to cart on account2
    When he attempts to order it as person using pickup delivery
    And he attempts to pay using transfer
    Then the order should be placed