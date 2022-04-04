Feature: Go to checkout using pickup delivery

  Customer should be able to make orders by using pick up delivery

  Scenario: Select Koszalin
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Koszalin
    Then she should see that she is on the payment page as a person

  Scenario: Select  Słupsk
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Słupsk
    Then she should see that she is on the payment page as a person

  Scenario: Select Szczecin
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Szczecin
    Then she should see that she is on the payment page as a person

  Scenario: Select Piła
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Piła
    Then she should see that she is on the payment page as a person

  Scenario: Select Toruń
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Toruń
    Then she should see that she is on the payment page as a person

  Scenario: Select Bydgoszcz
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Bydgoszcz
    Then she should see that she is on the payment page as a person

  Scenario: Select Wrocław
    Given that Ellen happens to be on the checkout with a product on PL
    When she selects delivery type pickup and chooses Wrocław
    Then she should see that she is on the payment page as a person
