Feature:Learning Cucumber


  # 1 - Pattern matching for any word or sentence using {} -->here "has launched" and "launches"
  Scenario: Check the different types of pattern matching
    Given User has launched the application
    And User launches the application
    When User "clicks" the button
    And User "checks" the checkbox
#    And He clicks the button  -->Not working, Check this


  # 2 - Multiple Given/When/Then annotations over single method
  Scenario: Multiple annotations over single method
    Given User has launched new app
    And User navigates to new app
    Then User verifies new app


  # 3 - Use of Data Tables
  Scenario: Use of 1-d DataTables 1st Way
    When User verifies following webelements
      | Apple  |
      | Banana |
      | Carrot |

  # 3 - Use of Data Tables (2nd Way) ==> THIS GIVES ERROR AND IS NOT THE CORRECT WAY TO DEFINE 1-d DataTables
#  Scenario: Use of 1-d DataTables 2nd Way
#    When User verifies following webelements
#      | Apple | Banana | Carrot |  ==> THIS GIVES ERROR AND IS NOT THE CORRECT WAY TO DEFINE 1-d DataTables, this will be treated as 2-d Datatable


  # 4- Use of 2-d Data Tables
  Scenario: Use of 2-d DataTables
    When User enters following details
      | Richu   | 1 |
      | Abhinav | 2 |
      | Prachi  | 3 |

  #5 - Use of Scenario Outline and Examples-->string should be with double quotes like "<User>" and int can be without quote like <Id>
  Scenario Outline: Use of Scenario Outline
    Then "<User>" verifies his <Id>
    Examples:
      | User    | Id |
      | Abhinav | 1  |
      | Prachi  | 2  |

