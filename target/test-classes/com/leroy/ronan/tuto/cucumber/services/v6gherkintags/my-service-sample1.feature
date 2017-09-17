@sample1
Feature: Sample 1

Background:
Given my service exists

Scenario: Sample 1, Scenario 1
 When my service does something
 Then it should have been a success

@ignore
Scenario: Sample 1, Scenario 2, ignore
 When my service does something
 Then it should have been a success

@wip
Scenario: Sample 1, Scenario 3, in progress
 When my service does something
 Then it should have been a success
 
@wip
@ignore
Scenario: Sample 1, Scenario 4, in progress but ignore
 When my service does something
 Then it should have been a success

 