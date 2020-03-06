Project Name: API_TestJsonResponse

Description: Assignment given by Assurity to verify API response (Tm_Sand_Box API Response Validation) by validating tag values

Automation Tool & Technologies Used: Intellij, Java, Maven, TestNg

Steps to execute the test and project settings information:

1. Download/ clone project from github https://github.com/bharatdixit01/API_TestJsonResponse
2. Open project in Intellij.
3. pom.xlm contains all build configuration settings required for project build setup.
4. Test file (tmSandBoxAPITest.java) is placed in API_TestJsonResponse/tree/master/src/test/java.
5. Config Property File (configFile.properties) contains baseURI and is placed under API_TestJsonResponse/tree/master/src/test/java/config.
6. In order to read config file Config File Reader class (ConfigFileReader) is created and placed in API_TestJsonResponse/tree/master/src/test/java/dataProviders
7. All 3 validation results will be displayed after executing project.
8. As there are only 3 validations hence I have choosen approach of validating in the test class rather than creating common method class and then calling methods in test class.
