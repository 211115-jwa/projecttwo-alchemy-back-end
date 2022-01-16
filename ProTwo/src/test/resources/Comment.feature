Feature: User can comment on a review

  Scenario: Posting a comment on a Review
    Given the user is on the page of a movie
    When the user click's comment on a specific review
    And the user enters data on the input box
    Then the comment is uploaded on the page of the review

	Scenario: Replying on a comment
		Given the user is on the page of a movie
		When the user click's reply on a specific comment
		And the user enters data on the input box
		Then the comment is uploaded on the comment tree