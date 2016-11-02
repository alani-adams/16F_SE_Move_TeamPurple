#Author: Sebastian Snyder, Cole Spears
Feature: Base Feature

Scenario Outline: Professor teaches Course
	* A "<professor>" teaches "<course>"

	Examples: CSV file
    | professor         | course            |
    | Clements, Curtis  | 201320 ACCT324.01 |
    | Brock, Sommer     | 201320 COMP353.01 |
    | Crisp, Charles    | 201320 IS324.01   |
    | Haley, Joyce      | 201320 JMC321.L4  |
    | Shilcutt, Jackie  | 201320 PEAC240.02 |
    | Reeves, Brent     | 201320 IT220.01   |
    | Reeves, Brent     | 201330 IT220.01   |
    | Reeves, Brent     | 201410 MGMT345.02 |
    | Bagley, Jo        | 201410 NUTR221.T1 |
    | Mitchell, Dan     | 201410 MPIN211.16 |