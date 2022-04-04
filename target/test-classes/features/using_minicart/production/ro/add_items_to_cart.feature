Feature: Add items to cart RO

  Customer should be able to add items to cart, by using
  add to card button on product page or by increasing
  amount inside the minicart.

  Scenario: Should add product from product page to minicart
    Given that Mindy has opened product page of a Grădină on RO
    When she tries to add it to cart
    Then she should see popup with "added to cart_RO" message

  Scenario: Should add product from product page to minicart
    Given that Mindy has clicked a product from a certain category on RO
    When she tries to add it to cart
    Then she should see popup with "added to cart_RO" message