Feature: IGIC calculator

  Background:
    Given I have a IGIC calculator

  Scenario Outline: Canary general VAT
    When tax is calculated for "<product>" with <price> price
    Then the result should be <result>

    Examples:
      | product | price | result |
      | diapers | 100   | 107    |
      | wine    | 7     | 7.49   |


  Scenario Outline: Canary super reduce IGIC
    When tax is calculated for "<product>" with <price> price
    Then the result should be <result>

    Examples:
      | product      | price | result |
      | common bread | 1     | 1      |
      | eggs         | 1     | 1      |
      | water        | 1     | 1      |

  Scenario: Canary reduced IGIC
    When tax is calculated for "clothes" with 20 price
    Then the result should be 20.6

  Scenario: Canary increased IGIC
    When tax is calculated for "cigar" with 3 price
    Then the result should be 3.45
