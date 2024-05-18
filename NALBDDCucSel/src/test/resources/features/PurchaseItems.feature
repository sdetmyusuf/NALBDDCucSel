Feature: Purchase any items

@storewise
Scenario Outline: purchase by selecting any store

When user clicks on "<Store name>"
Then user is able to see the page with "<Store name>" opened
When user searches the "<product name>"
Then user is able to see "<product name>" enlisted there.
 


Examples:
|Store name|product name|
|Store|Basic Blue Jeans|