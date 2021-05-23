Feature: create project

  Background:
    Given I am authorized


  Scenario:

    Given I am on project page
    When I fill description field
    And I select business unit org
    And I select contact
    And I select business unit
    And I select curator
    And I select projectRP
    And I select administrator
    And I select manager
    And I click save and close button
    Then I see success message





