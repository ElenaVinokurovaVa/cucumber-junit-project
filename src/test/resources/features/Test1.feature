@B26G12-55
Feature: Testing Grid dropdown

	Background:
		Given User is logged in under  vehicle feature


	@B26G12-53 @B26G12-8
	Scenario: Automation User should be able to click Export Grid dropdown
		When User click Export Grid dropdown
		Then User Should be able to see options CSV and XLSX	

	
	@B26G12-54 @B26G12-8
	Scenario: Export Grid dropdown is on the left of the page
		Then User see the Grid dropdown is on the left of the page