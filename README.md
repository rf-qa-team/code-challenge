# Automation tests basic framework
This repository contains draft automation framework for api and web testing. 

#Technologies
Project uses such technologies:
- Java16
- TestNg
- Rest-assured
- spring jdbc 
- lombok
- allure
- cucumber
- Jackson

#Structure
1. All tests  are written in gerking style and tests places in "src/test/resources/features". 
2. Step definition situated in "src/test/java/com/stepdefinitions" 
3. Api/ db models, utils etc is in "main/java/model"
4. Paramsa stroes as constants in separate clases in "main/java/params"
5. All util classes strore in "main/java/util" prefrebly to make methods as static 

#To start
This project uses Java 16. If you don't have one yet go to https://www.oracle.com/java/technologies/javase-jdk16-downloads.html and install it.
This project is built using gradle. 
## To Build
Run `./gradlew clean build`(or `./gradlew assemble` if you don't want to run tests and quality checks)
#To run tests
Run `./gradlew clean build` to run the tests
