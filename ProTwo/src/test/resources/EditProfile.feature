Feature: User can edit or update profile

  Scenario: Edit information correctly
    Given the user is on the edit profile page
    When the user enters the correct
    Then the user should be notify that the data is save

	Scenario: Edit information incorrectly
		Given the user is on the edit profile page
		When the user enters an incorrect data
		Then the appropriate error message should appear