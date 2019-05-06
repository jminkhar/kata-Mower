# new feature
# Tags: optional

Feature: A description

  Scenario: Test Tondeuse
    Given A maximum of height : 6 and width : 6
    When Tondeuse in 1 2 "N"
    And Tondeuse receive order "AGAADGA"
    Then result should be "0 3 W"
  Scenario: Test Process
    Given A commands processor
    When Commands are : 5 5,1 2 N,GAGAGAGAA,3 3 E,AADAADADDA
    And start processing
    Then result should be : 1 3 N,5 1 E