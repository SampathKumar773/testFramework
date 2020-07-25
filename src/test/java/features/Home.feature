Feature: The purpose of this feature file is to test the Mercury Tours Application

  @TC01 @HomePage
  Scenario Outline: Login[O] - 01: This scenario is to test the login functionality of the Spectrum
    Given the user hits the Mercury Tours application <URL>
    Then the user should see the Home page

    Examples: 
      | URL                          |
      | http://newtours.demoaut.com/ |
