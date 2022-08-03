Feature: BookIT application UI and DB en to end test

  @wip @db2
  Scenario: UI and DB user verification
    Given User logs into Ui app with "sbirdbj@fc2.com" and "asenorval"
    When User navigates to Myself page and gets user info
    And User send a query to bookiT DB with "sbirdbj@fc2.com"
    Then Ui and DB information should  match
