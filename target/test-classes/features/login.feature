Feature: Login into application

Scenario Outline: Positive test validating login

Given Initilaize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site 
And click on login link in homepage to land on sign in page
When user user enter <username> and <password> and logs in
Then verify that user is successfully logged in
And close browser

Examples:
|username	|password	|
|test99@gmail.com | 123456 |
|test123@gmail.com	|	12345	|

