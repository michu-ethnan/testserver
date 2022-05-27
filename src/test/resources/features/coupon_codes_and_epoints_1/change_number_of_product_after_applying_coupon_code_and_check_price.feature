Feature: Change the number of product after applying coupon code and check the price

  A customer should be able to increase the amount of product after applying coupon code
  and see the discount price is higher.


  Scenario: 1
    Given that Hanna applied a coupon code on checkout page
    And she sees the discount price
    When she increases the amount of product
    Then she should see that the discount is higher

  Scenario: 2
    Given that hanna applied a coupon code on checkout page after adding two products
    And she sees the discount price
    When she decreases the amount of product
    Then she should see that the discount is smaller

  Scenario: 3
    Given that Hanna applied a coupon code on payment page as a person
    And she sees the discount price
    When she increases the amount of product
    Then she should see that the discount is higher

  Scenario: 4
    Given that hanna applied a coupon code on payment page as a person after adding two products
    And she sees the discount price
    When she decreases the amount of product
    Then she should see that the discount is smaller