Feature: User can post a Review

  Scenario: Posting a Review
    Given the user is on the page of a movie
    When the user can enter a review on the input box
    Then the review is uploaded on the page of the movie
