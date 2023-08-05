Feature: Login with excel sheet

Scenario Outline: Login data from excel
Given User launches browser
And opens url ""
When User navigates to my account menu
And click on login
Then check user navigates to my account page by passing username passwprd from excel ror "<row_index>"

 Examples:
 |row_index|
 |o|
 |1|

