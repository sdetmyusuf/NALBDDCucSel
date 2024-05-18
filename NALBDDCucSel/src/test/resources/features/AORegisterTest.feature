Feature: user registers on AO app

@AORegister
Scenario Outline: User register with valid detais

Given user clicks on Account tab
When user enters the "<userName>", "<email>" and "<password>"
And user clicks on submit button
Then user registeration is completed for the "<userName>"

Examples:
|userName|email|password|
|Yusuf Khan|mohdmyyusuf2@gmail.com|test@123|