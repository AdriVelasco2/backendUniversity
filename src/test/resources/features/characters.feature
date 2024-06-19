Feature: Character

  Scenario Outline: Search a character by his id
    Given The user wants to search a character by id in the Rick and Morty API
    When The user sends a request to search a character by id "<id>"
    Then The user should get the character with id "<id>"
    And The status code should be 200
    And The character name should be "<name>"

    Examples:
      | id | name          |
      | 1  | Rick Sanchez  |
      | 2  | Morty Smith   |
      | 3  | Summer Smith  |

  Scenario Outline: Check the endpoint content
    Given The user wants to search a character by id in the Rick and Morty API
    When The user sends a request to search a character by id "<id>"
    Then The user should get the character with id "<id>"
    And The response should contain character details

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  Scenario: Check invalid character id
    Given The user wants to search a character by id in the Rick and Morty API
    When The user sends a request to search a character by id "9999"
    Then The status code should be 404
    And The error message should be "Character not found"

  Scenario: Check character attributes
    Given The user wants to search a character by id in the Rick and Morty API
    When The user sends a request to search a character by id "1"
    Then The user should get the character with id "1"
    And The character should have a name
    And The character should have a status
    And The character should have a species
    And The character should have a gender
    And The character should have an origin