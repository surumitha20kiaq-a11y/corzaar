Feature: student login and course exploration 

Background:
Given user is on the Corzaar login page

Scenario Outline: verify full name field with invalid names 
When user enter invalid "<Names>" 
Then  student not login with invalid Name 

Examples:
|Names           |     
|4567890         |
|8765430987654342|
|!@#$%^          | 
|priya           |          

Scenario Outline: verify student cannot login with invalid mobile numbers
When user enter invalid mobile "<MobileNumber>" 
Then  student not login with invalid mobile number 

Examples:
|MobileNumber    |     
|4567890         |
|8765430987654342|
|!@#$%^          | 
|priya           | 

Scenario: verify the learner login page with valid credentials 
When user enter valid mobile number and name
And user successfully verify the OTP
Then  student successfully login and navigate to course explore page.

Scenario: verify the public user access courses module 
When user click the courses module
Then user successfully navigate to the courses detailed page

Scenario: verify the discipline dropdown values clickable and relevent courses displayed
When user select the discipline dropdown values one by one
Then user successfully select the values and view the relevent courses

Scenario: verify the delivery format and free enrollment checkbox
When user click the delivery format and free enrollment checkbox one by one and verify the displayed courses
Then user successfully click the all delivery format checkbox


	