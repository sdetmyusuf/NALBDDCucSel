@TestMpthree
Feature: purchasing mp3


Scenario Outline: User selects and purchases the mp3

Given User moves to mp3 page
When user seaches the product with "<mp3name>"
Then User is able to see the "<mp3name>" on the page
Then user clicks on it and verifies its "<details>"

Examples:
|mp3name|details|
|iPod Shuffle||