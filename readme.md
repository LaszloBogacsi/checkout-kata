# Checkout kata

Implementation of a supermarket checkout that calculates the total price of a number of items

#### Assumptions:
- Item:
    - the price is type of double
    - the properties are always valid
        - sku is in valid format
        - price is a non-negative double
        
- Rule:
    - the properties of a rule are always valid
    - one rule can be applied to many items
- Checkout
    - Rules should not change once passed in to checkout process
    - can only add items (scan)
    - can not delete or modify an item once scanned
    - an item can have only one pricing rule but one rule can be applied to many items
    - all the items in the basket with rules have the matching rule in the rules list.