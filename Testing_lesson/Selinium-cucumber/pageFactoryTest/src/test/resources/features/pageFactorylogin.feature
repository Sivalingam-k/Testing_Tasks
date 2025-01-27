#Author
#Date

Feature: Login page automation of saucedemo application

Scenario: Check Login is successfull with valid credentials

Given user is on login page
When User enters valid "<username>" and "<password>"
And clicks on login button
Then user is navigated to the home page
And Close the browser

Examples:

|username|password|
|standard_user|secret_sauce|