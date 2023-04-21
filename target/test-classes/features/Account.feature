Feature: Portal Login

  Background: 
   Given Validate the browser
   When Browser is triggered
   Then check if browser is started
	
	@PortalTest
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "jim" and password "1234"
    Then Home page is populated
    And Cards displayed are "true"
	
	@PortalTest
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "john" and password "4321"
    Then Home page is populated
    And Cards displayed are "false"
	
	@PortalTest
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "john" and password "4321"
    Then Home page is populated
    And Cards displayed are "false"
	
	@PortalTest
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User sign up with following details
      | Duggi | Adi Narayana Reddy | adi091998@gmail.com | 9494700924 | Markapur |
    Then Home page is populated
    And Cards displayed are "false"
	
	@PortalTest
  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login in to application with <Username> and password <Password>
    Then Home page is populated
    And Cards displayed are "true"

    Examples: 
      | Username | Password |
      | user1    | pass1    |
      | user2    | pass2    |
      | user3    | pass3    |
      | user4    | pass4    |
