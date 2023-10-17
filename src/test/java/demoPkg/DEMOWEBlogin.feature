
Feature: loginDEMOWEB feature


  @tag2
  Scenario Outline: Title of your loginDEMOWEB feature
  
   Given  login the URL "https://demowebshop.tricentis.com/"
   And  click on "Log in" button
  And user enter details "<Email>" and "<Password>" 
  And user click on login button
  Then I verify the "<Email>" in login screen
  

    Examples: 
      | Email  | Password |
      | he!!o@email.com | pa123456 |
      
