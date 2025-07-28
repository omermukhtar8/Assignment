# Project Submission

---
## Purpose

To provide automated solution for UI and API Automation

---
## Technology Stack
* Java
* Maven
* Selenium
* Rest Assured
* TestNG

---

## Test Execution
* Steps:
    * Go to src -> test -> java -> UI -> Tests -> SignUpFunctionality
    * Change the String passed to  'signUp.enterEmailAndCreate("unique_email_for_test@mail.com")' everytime before execution to a unique email so that sign up is successful
    * Go to src -> test -> Utilities -> right click -> 'Mark Directory as' -> "Test Sources Root"
    * Right click on testng.xml and click Run
    * After execution, report can be fetched from reports -> index.html
    
---
## Test Cases
* UI Tests:
    * UI Tests are present in src -> test -> java -> UI -> Tests
    * API Tests are present in src -> test -> java -> API -> UserTests
    

## Structure Overview

* UI Automation
    * All tests are inherited from a base class which handles the object initialization
    * All the tests uses custom methods from different classes under "Pages" folder
    * All the POM classes uses "Utilities" class for selenium waits.

* API Automation
    * Base URI of the API is fetched from config.properties
    * POJO classes are present under "API" folder for serialization and deserialization

