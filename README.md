Why Framework?RestAssured Framework created with Maven, TestNG, Extent Reports and Git
======================================================================================

How to configure and run tests in this framework?
-------------------------------------------------
1. Clone this repository
2. Configure the test classes that needs to be run in the 'Testng.xml' file under the 'classes' section
3. Check whether the urls mentioned in the 'routes.properties' file in the 'src/test/resources' folder
4. Make sure this 'testng/xml' file is mentioned under 'suiteXmlFiles' section in the 'pom/xml' file
5. From the terminal, from the porject root directory, run this command - "mvn clean test"
6. The test logs are saved in the 'logs' folder (The log level is set to 'INFO'; if more logs are required, make sure to change it in the 'log4j2.xml' file in the 'src/test/resources' folder)
7. The test run reports are saved in the 'reports' folder.

Why do we need a Framework for api automation?
----------------------------------------------
1. Re-usability
2. Maintainability
3. Readability

Phases of Framework Development
--------------------------------

1. Understand the requirement
  - Functional Specifications (usability)
  - Swagger link (api documentation)
2. Choose the right automation tool
  - Eg: RestAssured library
3. Design the framework
  - Folder structure
  - Files required
  - Test cases to be automated
4. Development
  - Implementation of the design
  - Approval from stakeholders (PO or Dev Team)
  - Creation of local and remote git repositories 
5. Execution / CI
  - Frequency of test runs
  - Pipeline configurations


Framework Model - Folder Structure
----------------------------------

1. Endpoints - where the urls, path params and query params are stored
2. Test Cases - where the test cases are configured
3. Testng.xml - where we configure the test run models
4. pom.xml - where we configure the dependencies and execution
5. Payloads - where the getters and setters are stored (pojo classes)
6. Utilities - where the utility files that are required like data providers, extent report, XL Utility are stored
7. Test data - where the pre-configured test data is stored in excel, txt or json format
8. Reports - where the TestNG reports or Extent reports are stored

