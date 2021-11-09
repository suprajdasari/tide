Feature: Tide Site Automate

Scenario Outline:Check The products Available
	Given Tide Site Url Open
	Then Hover on Shop Products
	And Click On powder
	And Check if product available or not
	Then search "<Product>" and check "<Product>"
	Then click one Learn More
	And under How to do Laundry varify How to Read Laundry Symbols
	
	
	
Examples:
	|Product|
	|Antibacterial|