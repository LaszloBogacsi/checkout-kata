# Checkout kata

Implementation of a supermarket checkout that calculates the total price of a number of items

#### Tech stack used:

- `Java8` + `JUnit5`
- `Gradle 4.x`

#### How to use it

- clone
- `cd checkout-kata` 
- `gradle test` from the project folder or run tests from IDE
- run the `main` method from the `Supermarket` class to play around with the checkout

#### Assumptions:
- Item:
    - the price is type of double
    - the properties are always valid
        - sku is in valid format
        - an item can have one rule at a time only
        
- Rule:
    - the properties of a rule are always valid
    - one rule can be applied to many items
    - the rule IDs are unique
    
- Checkout
    - rules cannot and should not change once the checkout process started
    - can only add items (scan)
    - can not delete or modify an item once scanned
    - an item can have only one pricing rule but one rule can be applied to many items
    - pricing rules associated with items might be missing from the passed in set of rules.
    
- Not tested methods:

    - toString() override methods
    - log() method in Checkout that logs a string message to the standard output 