#Sureshmanikandan
#10/7/2024

Feature: Login page automation of saucedemo application
Scenario: Check login is successful with valid credentials

    Given User is on Home page
    #When User click on  about button
    #Then user is navigated to about page
    #And clicks on login button
   
    When User enters valid "<username>" and "<password>"
    And clicks on login button
    Then user is navigated to the OIl page
      And clicks on Oil button
    Then user is navigated to the Vegetables page
     And clicks on VEgetable button
    Then user is navigated to the Pulses page
     And clicks on Pulses button
    Then user is navigated to the Fruits page
     And clicks on Fruits button
    Then user is navigated to the Diary  page
     And clicks on Diary button
    
     And clicks on Logout button
    Then Close the browser
  

    Examples: 
      | username  | password |
     |manoj@gmail.com|Manoj@123|
      
      



