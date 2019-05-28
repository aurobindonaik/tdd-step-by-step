Feature: Checks The health and Application Version

  Scenario: Checks the health of the application
    When client calls the GET end point /healthz
    Then the client receives a response All UP and Running
    And the client receives a status SUCCESS