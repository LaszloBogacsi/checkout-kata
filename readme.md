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
- Checkout
    - Rules shouldn't change once passed in
    - can only add items (scan)
    - can not delete or modify an item once scanned