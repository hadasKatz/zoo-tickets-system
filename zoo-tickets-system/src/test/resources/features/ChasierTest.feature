
Feature: cashier flow

  Scenario: cashier handles a purchase request
    Given I have the request details
      | timeStamp | id  | discount |
      | 02:00     | 9   | 20       |
      | 03:00     | 10  | 10       |


    When I create a new tickets


    Then The ticket should be
    | price | entranceTime | id |
    | 80    | 02:00        | 9  |
    | 90    | 03:00        | 10 |

