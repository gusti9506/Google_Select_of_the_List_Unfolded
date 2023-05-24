@Test1
Feature: Google search.

    Scenario: Do a search on google.com
        Given The user is located on google.com
        When The user try to search for qa automation
        And The user clicks on the button 'Search in Google'
        Then It should show the related search