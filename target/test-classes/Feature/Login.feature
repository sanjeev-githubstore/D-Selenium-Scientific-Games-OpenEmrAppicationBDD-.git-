@login
Feature: Login
          In order to maintain medical record
          As a portal manager
          I want to login to OpenEMR Dashboard
    
    Background:
        Given I have browser with Open EMR page 

@invalid @lowpriority
  Scenario: Invalid Credential
    When I enter username as "admin123"
    And I enter password as "pass123"
    And I select language as "English (Indian)"
    And I click on login
    Then I should get the error message "Invalid username or password"

@valid
  Scenario Outline: Valid Credentials
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I select language as "<language>"
    And I click on login
    Then I should get access to the dashboard with title "OpenEMR"

    Examples: 
      | username   | password   | language         |
      | admin      | pass       | English (Indian) |
      | physician  | physician  | English (Indian) |
      | accountant | accountant | English (Indian) |
