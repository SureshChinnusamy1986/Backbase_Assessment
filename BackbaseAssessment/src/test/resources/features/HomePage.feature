Feature: Open a herokuapp website and validate the home page feature




    @SearchComputer
    Scenario Outline: To find a given computer is available in the database

      Given I navigate to the herokuapp website
      And I landed on the herokuapp website
      Then Input "<COMPUTER NAME>" in the text field in the top left corner of the screen
      When Click the 'filter by name' button in the text field in the top left corner of the screen
      Then "<COMPUTER NAME>" is displayed in the screen

      Examples:
        |COMPUTER NAME|
        |  ARRA       |


