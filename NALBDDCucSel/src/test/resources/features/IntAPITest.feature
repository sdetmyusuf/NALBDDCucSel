Feature: User creation and fetching

@ProdTest
Scenario Outline: User is able to create and see the details with API request

When user hits the request to the server with "<id>"
Then user is created with "<id>"

Examples:
|username|email|
|testuser|test@example.com|
