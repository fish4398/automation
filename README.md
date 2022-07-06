# automation
Automation Framework Selenium Java

# SYSTEM REQUIREMENTS
JDK All Version
Chrome Browser, Edge Browser

Setup Allure 
Download jar and setting Variable Environment as Java JDK

# HOW TO USE
1. Run parallel the test case

Run test case in suite XML (src/test/resources/suites/)

Run test case from Maven pom.xml file (mvn clean test)

2. Read Object web element from Properties file

3. Extent Report

Insert "FrameworkAnnotation" as sample or none:

The base value read from Enums (src/main/java/lifetek/vn/enums)
Setup on TestListener and BaseTest

4. Allure Report

Open Terminal: allure serve target/allure-results

Insert @Step("title/message") above @Test or any Method in the project
(As sample picture above step 3)

5. Log to file

Call class: Log.info , Log.pass, Log.error,... (Log is a custom global class from Log4j2) (import lifetek.vn.utils.Log.java)

6. Record video and Screenshot

Setup in config.properties file (src/test/resources/config/config.properties)

screenshot_passed_steps=yes or no

screenshot_failed_steps=yes or no

screenshot_skipped_steps=yes or no

screenshot_all_steps=yes or no

7. Read data test from Excel file

Create function with annotaion DataProvider on src/test/java/lifetek/vn/projects/website/crm/dataprovider/DataProviderManager.java
Read excel with Map and Hashtable
8. Base function in the package

src/main/java/lifetek/vn/utils
src/main/java/lifetek/vn/helpers
9. Read data test from JSON file

JsonUtils class select the json file path and call "get" method with key
10. Main Keyword: WebUI

WebUI class is main keyword in Framework. It contains common functions
How to use: WebUI.function_name
Example: WebUI.setWindowSize(1024, 768), WebUI.screenshotElement(By by, String elementName),...
11. Call function to using sample

All in one package: src/test/java/lifetek/vn/projects/website/crm/testcases
