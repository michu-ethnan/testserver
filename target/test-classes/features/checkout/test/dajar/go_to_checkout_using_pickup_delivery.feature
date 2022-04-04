Feature: Go to checkout using pickup delivery

  Customer should be able to make orders by using pick up delivery

  Scenario: Select Koszalin
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Koszalin as a person
    Then he should make the order as a person using transfer

  Scenario: Select  Słupsk
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Słupsk as a person
    Then he should make the order as a person using transfer

  Scenario: Select Szczecin
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Szczecin as a person
    Then he should make the order as a person using transfer

  Scenario: Select Piła
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Piła as a person
    Then he should make the order as a person using transfer

  Scenario: Select Toruń
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Toruń as a person
    Then he should make the order as a person using transfer

  Scenario: Select Bydgoszcz
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Bydgoszcz as a person
    Then he should make the order as a person using transfer

  Scenario: Select Wrocław
    Given that Ellen happens to be on the checkout with a product on testServerDajar
    When she selects delivery type pickup and chooses Wrocław as a person
    Then he should make the order as a person using transfer
