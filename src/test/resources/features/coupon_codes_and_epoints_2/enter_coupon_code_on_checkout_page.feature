Feature: Enter coupon code on the checkout page

  A customer should be able to enter a coupon code on the checkout page. The code applied should be visible after
  refreshing the page.

  Scenario: Enter coupon code on checkout page

    Given that Cindy happens to be on the checkout page as person
    When she enters a coupon code into the coupon code input
    Then she should see that the code is applied

  Scenario: Enter coupon code on checkout page and refresh

    Given that Cindy happens to be on the checkout page as person
    When she enters a coupon code into the coupon code input
    And she refreshes the checkout page
    Then she should see that the code is applied

  Scenario: Enter coupon code on checkout page, go to payment and return

    Given that Cindy happens to be on the checkout page as person
    When she enters a coupon code into the coupon code input
    And she proceeds to the payment page
    And she returns to the previous page
    Then she should see that the code is applied