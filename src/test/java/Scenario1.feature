Feature:As a user I want to make calculations using Android calculator

Scenario:
  Given I open calculator
  When I add 4 + 5
  And I expect result to be 9
  Then I clear screen
  Then I multiply 5 and 6
  When I expect result to be 30

