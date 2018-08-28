Feature: senior entrance flow

  Scenario: senior enters the zoo flow
    Given I have senior details

    When I apply senior post entrance request
      | id | timeStamp | age |
      | 5  | 01:00     | 65  |
      | 6  | 01:30     | 70  |

    Then The senior ticket should be
      | id | entranceTime | price |
      | 5  | 01:00        | 35    |
      | 6  | 01:30        | 30    |
