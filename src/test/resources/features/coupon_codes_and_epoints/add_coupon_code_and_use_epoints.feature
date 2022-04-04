@Ignore
Feature: Add coupon code and use epoints

  A customer should be able to add a coupon code and then use ePoints. He should also be able to use ePoints and then
  add a coupon code. Both discounts should be visible.

  Scenario: Should be able to

    Given that Elise is able to log in
    When she wants to submit an order and pay using transfer
    And she applies a coupon code
    And she enters epoints
    Then she should see that the epoints discount is visible
    And she should see that the coupon code discount is visible
    And remove discounts