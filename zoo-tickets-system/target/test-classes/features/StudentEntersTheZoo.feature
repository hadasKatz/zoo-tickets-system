Feature: student entrance flow

  Scenario: student enters the zoo flow
    Given I have student details

    When I apply student post entrance request
      | id | timeStamp|
      | 7  | 01:00    |
      | 8  | 01:30    |

    Then The student ticket should be
      | id | entranceTime | price |
      | 7  | 01:00        | 90    |
      | 8  | 01:30        | 90    |
