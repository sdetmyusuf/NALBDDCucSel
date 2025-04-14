Feature: Mark the country as visited

@testCapital
Scenario Outline: User is able to mark the country as visited

Given user is able to check if the "<capital>" is available on the page
When user extracts the coutry name for the "<capital>"
Then user is able to mark the coutry as visited for the "<capital>"

Examples:
|capital|