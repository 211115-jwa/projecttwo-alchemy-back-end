Feature: Adding a friend in any page page of the web site

 	Scenario: Adding a Friend
    	Given the user is on the web site no page in particular
    	When the user clicks add friend to another user
    	Then the user is successfully add friend to the list

	Scenario: Removing a Friend
		Given the user is on the web site no page in particular
		When the user clicks remove friend to another user
		Then the user is successfully remove from the friend list