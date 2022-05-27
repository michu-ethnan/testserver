Feature: Delete a coupon code on the checkout page as a logged in user

  A logged in user should be able to delete a coupon code on the checkout page.

  Scenario: Delete coupon code on checkout page logged in

    Given that Demi is a logged in user
    When she adds a coupon code
    And she deletes the coupon code
    Then she should see that the code is not visible

    Scenario: Return from payment page and delete coupon code on checkout page logged in

      Given that Demi is a logged in user
      When she adds a coupon code
      And she attempts to go to the payment page
      And she returns to the previous step
      And she deletes the coupon code
      Then she should see that the code is not visible
