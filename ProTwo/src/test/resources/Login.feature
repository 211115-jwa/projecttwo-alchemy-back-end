Feature: Logging in to the Movie Homepage

  Scenario: Logging in correctly
    Given the user is on the movie login page
    When the user enters the username and password
    Then the user should be taken to a different page

	Scenario: Logging in incorrectly
		Given the user is on the movie login page
		When the user enters an incorrect username and password
		Then the appropriate error message should appear