Feature: Patient
         In order to maintain the patient records
         As an admin
         I want to create, update, delete patient records

  @patient
  Scenario: Add Patient
    Given I have browser with Open EMR page
    When I enter username as "admin"
    And I enter password as "passs"
    And I select language as "English (Indian)"
    And I click on login
    And I mousehover on patient-client
    And I click on patients
    And I click on add new patient
    And I fill the patient detail
      | firstname | lastname | dob        | gender |
      | Tom       | Hill     | 2021-05-17 | Male   |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle alert
    And I close happy birthday pop up when available
    And I validate alert message receiver "Assessment: Tobacco"
    And I validate the added patient detail "Medical Record Dashboard - Tom Hill"