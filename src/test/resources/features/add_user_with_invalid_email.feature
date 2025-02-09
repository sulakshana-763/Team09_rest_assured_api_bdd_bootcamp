Feature: Add New User with invalid email

Background: Basic Auth for post request  

Scenario: Verifing POST request for adding new user with invalid email

Given POST request for adding new user 
When Add new user POST request is send with invalid email
Then The status recieved is not found