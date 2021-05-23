Feature: create project

  Background:
    Given I am authorized



#    Scenario:
    Scenario Outline: параметризованный сценарий
      Given I am on project page
      When I fill '<description>' field
      And I select business unit org
      And I select contact
      And I select business unit
      And I select curator
      And I select projectRP
      And I select administrator
      And I select manager
      And I click save and close button
      Then I see success message
      Examples: наш тест запустится сначала со значением test1  а потом со значением test2
        | description |
        |test1        |
        |test2        |



