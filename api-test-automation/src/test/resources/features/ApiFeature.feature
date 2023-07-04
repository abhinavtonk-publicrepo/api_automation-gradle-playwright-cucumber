Feature: Basic API Feature

  Background: Initializing the API Request
    Given User has initialized the API Request for 'https://reqres.in/' url


  Scenario: Test GET Request
    When User makes a GET call
    Then User verifies that response is OK

  Scenario: Test POST Request
    Given User makes a POST call to 'api/users' endpoint
    Then User verifies that response is OK

  @test
  Scenario: Test Json De-serialization
    When User do deserialization from json file to Pojo


  Scenario: Test Json comparison
    And User makes a GET call to 'api/users/2' endpoint and verify response json to stored json