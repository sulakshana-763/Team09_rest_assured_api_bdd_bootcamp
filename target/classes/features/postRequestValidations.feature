@tag
Feature: Post API Validations

  Background: user sets authorization as basic
    Given User sets Auth type as basic auth and enters "username" and "password"

  @post1
  Scenario: validate new user created using valid fields
    Given new user request payload with valid fields and sets Post with valid URI
    When user sends the "Post" with "PostRequestAPI"
    Then user receives "status code" as "201"

  @get
  Scenario: validate Get by userid with valid userid
    Given user sets get request with valid userid
    When user sends the  "Get" request with "GetUserIdAPI" 
    Then user receives "status code" as "200" with response payload
    
 #@put
  #Scenario: validate Get by userid with valid userid
    #When user sends the "Put" with "PutRequestAPI"
    #Then user receives "status code" as "201"
    #
  @Delete
  Scenario: validate delete by userid with valid userid
   Given user sets delete request with valid userid
    When user sends the delete request "Delete" with "DeleteUserIdAPI"
    Then user receives "status code" as "200" ok
    And user receives "status" as "Success" message