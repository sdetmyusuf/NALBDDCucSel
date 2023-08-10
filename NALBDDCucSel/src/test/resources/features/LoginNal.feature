Feature: User login

@testOne
Scenario: login with valid credentials
Given User opens the applicattion url
#When User enters email address "mohdmyyusuf@gmail.com"
#And Enter valid password "Ilovenal@143"
#And clicks login button
#Then User should get logged in successfully

Scenario: Login with invalid credentials
Given User opens the applicattion url
When User enter invalid email address "mohdmyyusuf1@gmail.com"
And Enter invalid password "Ilovenal1@143"
And clicks login button
Then User should get a proper warning message

Scenario: Login with valid email address and invalid password
Given User opens the applicattion url
When User enter valid email address "mohdmyyusuf@gmail.com"
And Enter invalid password "Ilovenal1@143"
And clicks login button
Then User should get a proper warning message 

Scenario: Login with invalid email address and valid password
Given User opens the applicattion url
When User enter invalid email address "mohdmyyusuf2@gmail.com"
And Enter invalid password "Ilovenal@143"
And clicks login button
Then User should get a proper warning message 

Scenario: Login without providing credentials
Given User opens the applicattion url
When User does not enter any credentials
And clicks login button
Then User should get a proper warning message 