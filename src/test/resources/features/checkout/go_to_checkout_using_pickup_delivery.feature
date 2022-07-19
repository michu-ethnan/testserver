Feature: Go to checkout using pickup delivery

  Customer should be able to make orders by using pick up delivery

  Scenario: Select Koszalin
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Koszalin as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Select  Słupsk
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Słupsk as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Select Szczecin
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Szczecin as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Select Piła
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Piła as a person
    And he attempts to pay using transfer
    Then the order should be placed
  Scenario: Select Toruń
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Toruń as a person
    And he attempts to pay using transfer
    Then the order should be placed
  Scenario: Select Bydgoszcz
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Bydgoszcz as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Select Wrocław
    Given that Ellen happens to be on the checkout with a product
    When she selects delivery type pickup and chooses Wrocław as a person
    And he attempts to pay using transfer
    Then the order should be placed
