Feature: Features of my service

Here you can write down anything you want, this is just a description of the feature, cucumber will ignore the text here.
Use this space to sum up the specification of yout feature, take notes about it, anything you think relevant.

A best practice for this description is to use the following syntax, it will help you describe the feature :
In order to [...achieve a goal...]
As [...an actor of the system...]
I want to [...perform a step that will lead me to the goal...]

Background:
Given my service exists

Scenario: Calling my service
 When my service does something
 Then it should have been a success

Scenario Outline: Calling my service in different ways
 When my service does <action>
 Then it should have been a <result>
Examples:
 | action    | result  |
 | something | success |
 | anything  | failure |
 
Scenario: Calling my service checking what happened
 When my service does nothing
 Then it should have been a success
  And my service should still be working
  But nothing should have happened

Scenario: Calling my service with parameters
Given allowed users are :
 | name  | surname | login  |
 | Roe   | Bill    | broe   |
 | Doe   | John    | jdoe   |
 | Smith | Bob     | bsmith |
 When "jdoe" calls my service, asking the user names
 Then the service should answer with 3 elements
  And the service should answer in less than 0.010 seconds
  And the response should be "Roe, Doe, Smith"

Scenario: Calling my service with a multiline message
Given the messages is
  """
  Here is a verv long messages.
  This message consists of several lines of text
  but is only one parameter
  """
 When my service does something
 Then message should have several lines
  