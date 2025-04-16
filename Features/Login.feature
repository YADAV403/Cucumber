Feature: Login

	Background: Common steps
	Given Launch the browser
	When Open URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	
	@Sanity
	Scenario: Login with valid credentials
	And Enter username as "Admin" and password as "admin123"
	And Click login button
	Then Verify title as "OrangeHRM"
	When Click logout button
	Then Verify title as "OrangeHRM"
	And Close the browser
	
	@Regression
	Scenario Outline: Data Driven
	And Enter username as "<email>" and password as "<password>"
	And Click login button
	Then Verify title as "OrangeHRM"
	When Click logout button
	Then Verify title as "OrangeHRM"
	And Close the browser
	
	Examples:
	|email|password|
	|Admin|admin123|
	|tony|tony123|
	
	