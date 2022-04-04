Feature: Enter a coupon code with discount higher than the order value

  After entering a coupon code with discount higher than the order value, a notification on the lack of any surcharge
  should be displayed.

  Scenario: Should be able to

    Given that Diane is going to finalize her transaction as person using transfer
    When she adds a coupon code with discount higher than the order value
    Then she should see a notification on the lack of any surcharge

  Scenario: Should be able to

    Given that Diane is going to finalize her transaction as person using transfer
    When she adds a coupon code with discount higher than the order value
    And she removes the coupon code
    Then she should see that the notification is not visible

  Scenario: Should be able to

    Given that Diane is going to finalize her transaction as person using transfer
    When she adds a coupon code with discount higher than the order value
    And she navigates back to the previous page
    Then she should see a notification on the lack of any surcharge

  Scenario: Should be able to

    Given that Diane is going to finalize her transaction as person using transfer
    When she adds a coupon code with discount higher than the order value
    And she reloads the page
    Then she should see a notification on the lack of any surcharge
