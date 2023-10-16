Feature: Title of your feature
  

  @tag1
  Scenario Outline: Login scenario 
    Given user login the URL "https://demowebshop.tricentis.com/"
    And user click on "Register" button
    When user enter details "<First name>" and "<Last name>" and "<Email>" and "<Password>" and "<Confirm password>" 
    And user click on Register button
    And verify the confirmation text
  
   Examples:  
    | First name | Last name | Email | Password | Confirm password |
    |student     |  Password123 | he!!o@email.com |  pa123456 | pa123456 | 

 