Feature: User login

   @sanity
   
   Scenario: Successfull login

          Given the user open the Amazon app page 
          When user enters email as "chittudove@gmail.com" and password as "Welcomeback@2023"          
          And  user click on Signin button
          Then user able to see the Account page
    
@regression
  Scenario Outline: Login Data Driven
    Given the user open the Amazon app page 
    When user enters email as "<email>" and password as "<password>"
     And  user click on Signin button
     Then user able to see the Account page
    
    Examples: 
      | email                	    | password |
      | chittudove@gmail.com 	      | Welcomeback@2023  |
 

 
      
 