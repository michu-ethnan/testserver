Feature: Order products from different categories

A customer should be able to add products from all categories

  Scenario: Order from Ogród
    Given that Alexa wants to order products from Ogród
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Kuchnia
    Given that Alexa wants to order products from Kuchnia
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Łazienka i garderoba
    Given that Alexa wants to order products from ŁazienkaIgarderoba
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Dekoracje
    Given that Alexa wants to order products from Dekoracje
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Świat dziecka
    Given that Alexa wants to order products from ŚwiatDziecka
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Nowości
    Given that Alexa wants to order products from Nowości
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Wyprzedaż
    Given that Alexa wants to order products from Wyprzedaż
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Promocje
    Given that Alexa wants to order products from Promocje page
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: Order from Inspiracje
    Given that Alexa wants to order products from Inspiracje page
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed



