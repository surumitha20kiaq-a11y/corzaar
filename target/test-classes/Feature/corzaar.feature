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
When user click the delivery format checkbox one by one and verify the displayed courses
Then user successfully click the all delivery format checkbox

Scenario: verify the program duration dropdown
When user click the  program duration dropdown one by one and verify the displayed courses
Then user successfully click the all program duration dropdown

Scenario: verify the free enrollment checkbox
When user click the free enrollment checkbox one by one and verify the displayed courses
Then user successfully click the free enrollment checkbox

Scenario Outline: Verify course sorting functionality
    When user selects "<sortValue>" from the sort dropdown
    Then courses should be sorted correctly by "<sortValue>"

Examples:
    | sortValue          |     
    | Highest Rated      |
    | Newest Releases    |
    | Price: Low to High |
    | Price: High to Low |
    | Most Enrolled     |
    
Scenario Outline: Verify course, skill and institute search functionality
When user searches for "<searchType>" using "<searchText>"
Then user should verify the "<expectedResult>" search result for "<searchType>" using "<searchText>"
Examples:
    | searchType | searchText                | expectedResult |
    | Course     | UI UX Design Fundamentals | Valid          |
    | Course     | InvalidCourse12345        | Invalid        |
    | Skill      | UI UX Design              | Valid          |
    | Skill      | InvalidSkill12345         | Invalid        |
    | Institute  | My institute              | Valid          |
    | Institute  | 12345                     | Invalid        |	
    
Scenario: Verify paid course enrollment page navigation
     When user selects a paid course
    And user clicks the Enroll Immediately button
    Then user should navigate to Review Your Enrollment page
    
 Scenario: Verify offer cards and copy coupon functionality
   When user navigates to the Offers module
    Then user should verify coupon code, percentage, active status and copy button
    When user clicks the Copy button for an offer
    Then user should see the coupon copied success message