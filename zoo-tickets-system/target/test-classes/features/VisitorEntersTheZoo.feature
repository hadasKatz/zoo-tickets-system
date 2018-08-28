Feature: visitor entrance flow

  Scenario: person enters the zoo flow
    Given I have firstName, lastName, timeStamp, id

    When I apply post entrance request
      | id | timeStamp|
      | 3  | 01:00    |
      | 4  | 01:30    |

    Then The result should be
      | id | entranceTime | price |
      | 3  | 01:00        | 100   |
      | 4  | 01:30        | 100   |







