# Reach Financial Code Challenge
This repository contains draft automation framework for api and web testing. 

## Technologies
Project uses such technologies:
- Java16
- TestNg
- Rest-assured
- spring jdbc 
- lombok
- allure
- cucumber
- Jackson

## Structure
### Description
- All tests  are written in gerkin style and tests places in `src/test/resources/features`
- Step definition situated in `src/test/java/com/stepdefinitions`
- Api/db models, utils etc is in `main/java/mode`
- Params stored as constants in separate classes in `main/java/params`
- All util classes store in `main/java/util` preferably to make methods as static 

### Tree
```
.
├── Dockerfile                                         
├── README.md                                           # README file
├── build.gradle                                        # Gradle build file
├── checkstyle.gradle                                   # Gradle checkstyle definition
├── checkstyle.xml                                      # Checkstyle rules
├── gradle                                              # Gradle Wrapper
├── gradlew                                             # Gradle build file (mac & linux)
├── gradlew.bat                                         # Gradle build file (windows)
├── pmd.gradle                                          # Gradle PMD definition
├── pmdrules.xml                                        # PMD rules
├── settings.gradle                                     # Gradle settings
└── src
    ├── main
    │         └── java
    │             ├── model                             # API/DB jackson models
    │             ├── params                            # Reusable parameters
    │             │         └── ...
    │             └── util
    │                 ├── datastore
    │                 │         └── DataStore.java      # Datastore base class (used in src/test/java/util/datastore/...)
    │                 ├── helper
    │                 │         ├── Assertation.java    # Assertion helper class
    │                 │         └── Converter.java      # Conversion helper class (string to ts)
    │                 ├── json
    │                 │         └── BuildJson.java      # Converting something from or to JSON
    │                 ├── obj2map
    │                 │         └── Introspect.java     # Converting object to or from a map
    │                 └── webdriver
    │                     ├── BasePageActions.java      # Base browser action class
    │                     ├── Browser.java              # Browser definition class
    │                     └── CustomProvider.java       # Webdriver creation class
    └── test
        ├── java
        │         ├── TestRunner.java
        │         ├── com
        │         │         └── stepdefinitions         # Where step definition classes should be defined
        │         │             └── Hooks.java          # Class for cucumber hooks
        │         └── util
        │             └── datastore
        │                 ├── ComDataDump.java          # Datastore for common steps
        │                 └── DataThreadLocals.java     # Datastore initialiation and thread management class
        └── resources
            └── cucumber.properties                     # Cucumber configs
```

## To start
This project uses Java 16. If you don't have one yet go to https://www.oracle.com/java/technologies/javase-jdk16-downloads.html and install it.
This project is built using gradle. 

## To Build
Run `./gradlew clean build`(or `./gradlew assemble` if you don't want to run tests and quality checks)
#To run tests
Run `./gradlew clean build` to run the tests
