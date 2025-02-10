@tag
Feature: Post API Validations
  Background: user sets authorization as basic
  Given User sets Auth type as basic auth and enters "username" and "password"
  

  @post1
  Scenario: validate new user created using valid fields
    Given new user request payload with valid fields and sets Post with valid URI
    When user sends the "Post request" with valid "endpoint"
    Then user receives "status code" as "201" 
    

  #@post2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |