Feature: Test the APIs for the book store

@APIsBooks
Scenario: User tests the APIs to fetch the books in the store

When user hits the url it is successfull
Then user is able to check the books details
And user is able to check the "<isbn>"
|9781449325862|