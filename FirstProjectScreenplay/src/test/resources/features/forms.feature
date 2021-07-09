Feature: practice fill form

  @regression
  Scenario: Fill form
    Given that a web user want to practice fill a web form
    When  he fill all the requested field in the form
    Then he should see his data in the register.

  @smokeTest
  Scenario: Fill form with excel
    Given that a web user want to practice fill a web form
    When  he fill all the requested field in the form with the information in excel
    Then he should see his excel data in the register.

  @configTest
  Scenario: Fill form with configuration file
    Given that a web user want to practice fill a web form
    When  he fill all the requested field in the form with the information in configProperties
    Then he should see his config data in the register.