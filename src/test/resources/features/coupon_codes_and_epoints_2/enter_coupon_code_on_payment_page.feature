Feature: Enter coupon code on the payment page

  A customer should be able to enter a coupon code on the payment page.

  Scenario: Enter coupon code on payment page

    Given that Patrick happens to be on the payment page
    And he fills in billing data as person
    When he enters a coupon code
    Then he should see that the code is added

  Scenario: Enter coupon code on payment page and refresh

    Given that Patrick happens to be on the payment page
    And he fills in billing data as person
    When he enters a coupon code
    And he refreshes the payment page
    Then he should see that the code is added