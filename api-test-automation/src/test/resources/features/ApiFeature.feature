Feature: Basic API Feature

  @test
  Scenario: Test Get Request
    Given User has made a GET call to 'api/users/2' endpoint
    Then User verifies that response is OK