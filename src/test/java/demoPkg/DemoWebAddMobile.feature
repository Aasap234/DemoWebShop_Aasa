
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Add Mobile
    Given user login URL
    And user update credentials and click on login
    And user click on ELECTRONICS button
    And user select cell phones link
    And user select Smartphone link
    And user click on ADD TO CART button
  Then verify text msg as Shopping cart in cast
    
  