Feature:Learning Cucumber


  # 1 - Pattern matching for any word or sentence using {} -->here "has launched" and "launches"
  Scenario: Check the different types of pattern matching
    Given User has launched the application
    And User launches the application
    When User "clicks" the button
    And User "checks" the checkbox
#    And He clicks the button  -->Not working, Check this

  @test
  # 2 - Multiple Given/When/Then annotations over single method
  Scenario: Multiple annotations over single method
    Given User has launched new app
    And User navigates to new app
    Then User verifies new app