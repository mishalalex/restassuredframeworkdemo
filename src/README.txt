Framework Development Steps
---------------------------
Pre-Requisites
---------------------------
01. Create a maven project
02. Configure the pom.xml
03. Create folder structure
---------------------------
Designing & Development
---------------------------
04. Create 'Routes.java' file which contains all the urls in the 'endpoints'  folder
05. Create endpoint module for a selected module which contains CRUD methods implementation (eg: user module) in the 'endpoints' folder
06. Create the corresponding payload class for the module (POJO Classes) in the 'payload' folder
07. Create tests for the module in the 'test' folder by calling the methods from endpoints and payload classes
08: Create data-driven tests to execute the tests by taking the test data from an excel-sheet using XLUtilities class & Data-Provider class
    (Data-Provider are methods which reads the test data from excel-sheet using the XLUtilities class, converts it into 2D arrays & pass it to the test methods)
09. Generate Extent test reports using ExtentReportManager class
10. Add logs to the test runs using Log4J2 library
---------------------------
CI & CD Process
---------------------------
11. Configure test execution from terminal using maven compiler and maven surefire plugins
12. Configure local and remote repository for the project using git and github (any any similar remote repository)
