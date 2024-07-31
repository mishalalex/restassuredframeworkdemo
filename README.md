Why Framework?
--------------
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
