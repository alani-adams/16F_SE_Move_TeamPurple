#Author: Sebastian Snyder, Cole Spears, Alani Peters
Feature: Base Feature

Scenario Outline: Student Availability
    Given Student "<banner>" on "<day>" between "<start>" and "<end>" in term "<term>"
    Then the student "<availability>" available

    Examples: Student availability
    | banner    | day | start | end  | term   | availability |
    | 000800457 | W   | 800   | 1000 | 201710 | is           |
    | 000800457 | T   | 1900  | 2000 | 201710 | is not       |
    | 000926944 | W   | 800   | 1000 | 201710 | is           |
    | 000662102 | F   | 915   | 930  | 201710 | is not       |
    | 000662102 | R   | 915   | 930  | 201710 | is           |
    | 000958628 | T   | 810   | 1000 | 201710 | is not       |
    | 000958628 | M   | 1400  | 1410 | 201710 | is not       |
    | 000958628 | F   | 851   | 900  | 201710 | is           |
    | 000534162 | M   | 810   | 1700 | 201710 | is not       |
    | 000454716 | R   | 1400  | 2000 | 201710 | is           |
    
Scenario Outline: Professor Availability
    Given Professor "<name>" on "<day>" between "<start>" and "<end>" in term "<termCode>"
    Then the Professor "<availability>" available

    Examples:
    | name                | day | start | end  | termCode | availability |
    | Reeves, Brent       | M   | 1300  | 1350 | 201710   | is not       |
    | Reeves, Brent       | W   | 1300  | 1350 | 201710   | is not       |
    | Reeves, Brent       | W   | 1400  | 1450 | 201710   | is not       |
    | Reeves, Brent       | T   | 800   | 920  | 201710   | is           |
    | Homer, John         | F   | 1300  | 1350 | 201710   | is not       |
    | Homer, John         | M   | 900   | 950  | 201710   | is not       |
    | Homer, John         | F   | 1400  | 1450 | 201710   | is not       |
    | Homer, John         | M   | 800   | 850  | 201710   | is           |
    | Homer, John         | R   | 1330  | 1500 | 201710   | is           |
    | Houghtalen, Brandon | W   | 1115  | 1250 | 201710   | is not       |
    | Houghtalen, Brandon | R   | 1000  | 1050 | 201710   | is           |
    
    
Scenario Outline: Professor Availability
    Given course "<course>" and time slot "<start>" to "<end>" on "<day>"
    Then "<amount>" amount of students have a conflict 
    And the professor "<available>" have a conflict

    Examples:
    | course            | start | end  | day | amount | available |
    | 201710 COMP602.02 | 800   | 1050 | W   | 8      | does not  |
    | 201710 CHEM463.L1 | 1300  | 1650 | M   | 0      | does not  |
    | 201710 CHEM463.L1 | 1330	| 1720 | R   | 2      | does      |
    | 201710 PHIL478.01 | 1300  | 1420 | T   | 4      | does      |
    | 201710 PHIL478.01 | 1300  | 1420 | R   | 5      | does      |
    | 201710 CS315.01   | 1330  | 1450 | T   | 16     | does      |
    | 201710 CS315.01   | 1330  | 1450 | R   | 16     | does      |
    | 201710 PHIL478.01 | 1100  | 1130 | T   | 10     | does not  |

