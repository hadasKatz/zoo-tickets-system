
Feature: solider enters the zoo flow

  Scenario: solider enters the zoo flow
    Given I have solider details

    When I apply solider post entrance request
      | id | timeStamp|
      | 1  | 01:00    |
      | 2  | 01:30    |

    Then The solider ticket should be
      | id | entranceTime | price |
      | 1  | 01:00        | 80    |
      | 2  | 01:30        | 80    |