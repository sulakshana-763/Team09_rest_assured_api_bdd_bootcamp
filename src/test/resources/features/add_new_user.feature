Feature: Add New User

Background: Basic Auth for post request  

Scenario: Verifing POST request for adding new user with valid fields

Given POST request for adding new user is set with valid fields
When Add new user POST request is send 
Then The status recieved is bad request

