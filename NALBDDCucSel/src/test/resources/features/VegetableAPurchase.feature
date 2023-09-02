Feature: vegetable selection and purchase
@vegpurchase
Scenario Outline: Search the vegetable and add to cart
When user enters the "<vegname>" of the vegetable to check availbility
Then user enters for "<vegname>" the "<quantity>"
Then user clicks add to cart for "<vegname>"

Examples:
|vegname|quantity|
|Carrot |2|
