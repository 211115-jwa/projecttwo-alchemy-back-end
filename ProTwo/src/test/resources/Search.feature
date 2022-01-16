Feature: Searching in the Movie Site

  Scenario: Search correctly
    Given the user clicks on the search bar on the site
    When the user enters the movie
    Then the user should be taken to a different page

	Scenario: Search incorrectly
		Given the user clicks on the search bar on the site
		When the user enters an incorrect movie
		Then the appropriate error message should appear