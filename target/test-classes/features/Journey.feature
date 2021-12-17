Feature: Automate Journey 1 and 2

  Background: 
    Given I navigate to the application successfully

  Scenario: Adviser guide PDF
    When I select the find out more button from Charges gadget
    And I verify that Charges page is loaded successfully
    Then I click Charges – SIPP, ISA or GIA download and ensure the PDF is displayed in new window

  Scenario Outline: Adviser registration validation with blank string
    When I select the Register icon in top navigation bar
    And I verify Adviser registration page is displayed
    And I click on continue button leaving the FCA firm reference blank and verify the <message>

    Examples: 
      | message                                          |
      | FSR number field is mandatory. Please try again. |

  Scenario Outline: Adviser registration validation with randon string
    When I select the Register icon in top navigation bar
    And I verify Adviser registration page is displayed
    And I click on continue button with <random-characters> into the FCA firm reference field and verify the <message>

    Examples: 
      | random-characters | message                                                                                      |
      | test              | We could not locate your firm. Please check that you have entered your FSR number correctly. |
