#Author: Sebastian Snyder, Cole Spears
Feature: Base Feature

Scenario Outline: Student Availability
    Given Student "<banner>" on "<day>" between "<start>" and "<end>" in term "<term>"
    Then the student "<availability>" available

    Examples: Student availability
    | banner    | day | start | end  | term   | availability |
    | 800457    | W   | 800   | 1000 | 201710 | is           |
    | 800457    | T   | 1900  | 2000 | 201710 | is not       |
    | 926944    | W   | 800   | 1000 | 201710 | is           |
    | 662102    | F   | 915   | 930  | 201710 | is not       |
    | 662102    | R   | 915   | 930  | 201710 | is           |
    | 958628    | T   | 810   | 1000 | 201710 | is not       |
    | 958628    | M   | 1400  | 1410 | 201710 | is not       |
    | 958628    | F   | 851   | 900  | 201710 | is           |
    | 534162    | M   | 810   | 1700 | 201710 | is not       |
    | 454716    | R   | 800   | 2000 | 201710 | is           |
    
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
