Feature: Add New User

Background: Basic Auth for post request  

Scenario: Verifing POST request for adding new user with valid fields

Given POST request for adding new user is set with valid fields
When Add new user POST request is send 
Then The status recieved is success

Scenario: Verifing GET request for newly added user with userId

Given GET request for adding new user is set with valid fields
When GET request to get newly added user with userId is send 
Then The status recieved is success with success code

Scenario: Verifing DELETE request for adding new user with valid fields

Given DELETE request for deleting new user is set with valid fields
When DELETE request with new user userId is send 
Then The status recieved is success with success code

