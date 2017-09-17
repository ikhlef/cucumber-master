@sample3
Feature: Sample 3

Background:
Given my service exists

Scenario: Sample 3, Scenario 1
 When my service does something
 Then it should have been a success

@ignore
Scenario: Sample 3, Scenario 2, ignore
 When my service does something
 Then it should have been a success

@wip
Scenario: Sample 3, Scenario 3, in progress
 When my service does something
 Then it should have been a success

@wip
@ignore
Scenario: Sample 3, Scenario 4, in progress but ignore
 When my service does something
 Then it should have been a success
 