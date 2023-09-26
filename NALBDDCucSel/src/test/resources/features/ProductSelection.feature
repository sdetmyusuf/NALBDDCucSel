Feature: Product selection

Scenario Outline: search and add product

Given user clicks on product links from "<menulink>" and "<productlink>"
When user seaches the product with "<productname>"
When user clicks on add to cart button
Then the product is added to the cart

Examples:
|menulink|productlink|productname|
|Laptops & Notebooks|Show All Laptops|HP LP3065|