Feature: Check the cart after the vegetable is added to it
@vegpurchase
Scenario: Check if the cart contains the correct vegetable
Given user clicks on cart icon and checks if empty
|Carrot - 1 Kg|
|2|
Then user checks the vegetable name to on the cart
|Carrot - 1 Kg|
Then user checks quantity to be correct on the cart
|2 Nos.|
Then user checks total to be correct on the cart
|112|
Then user clicks checkout button


