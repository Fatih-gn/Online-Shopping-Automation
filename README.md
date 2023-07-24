
# Online Shopping Automation 

### **Selenium Cucumber Project**

This repository contains a collection of selenium Cucumber project that is written with Java language and libraries that show how to use the tool and develop automation scripts using the Cucumber BDD framework with Java. 

### **Installation guide** 

This is a maven project. So it’s assumed that the host running this code has Java and Maven installed and JAVA_HOME already set. Here is the guide for Maven installation just in the link: https://maven.apache.org/install.html Project gets all dependencies from Maven repository. So no additional installation is needed. The tools are managed by adding dependencies to the pom.xml file which is for this framework and test.
JDK 1.8+ (make sure Java classpath is set) Maven (make sure .m2 classpath is set) IntelliJ/Eclipse IntelliJ/Eclipse Plugins for Maven Cucumber Git

### **Set up** 

Fork / Clone repository from [here](https://github.com/Fatih-gn/Online-Shopping-Automation-) or download the zip and set it up in your local workspace.

### **Framework**

The cucumber BDD testing framework specifies acceptance tests as written from the view of the Product Owner. Using keywords such as Given, When, Then and And, acceptance criteria tests known as feature files can then be broken down into testable steps. The Cucumber Selenium framework runs by specifying the test cases using tags that are to be run. Cucumber Selenium - Overall test framework leveraging the Cucumber framework with Selenium written in JAVA.
POM is used as a design pattern. POM creates an object repository for storing all web elements. It helps reduce code duplication and improves test case maintenance. In the Page Object Model, consider each web page of an application as a class file. Each class file will contain only corresponding web page elements. Using these elements, we can perform operations on the website under test. POM structure:
![Project Structure for POM ](https://github.com/Fatih-gn/Online-Shopping-Automation-/assets/140351317/f70fe077-2e94-49d0-a897-0ebab07b3d86)


**Framework Structure:**

- **pom.xml:**  It is used to download and upload libraries and tools using dependencies and builds that you will need in the framework. Below are the dependencies are being used for this project :

    Selenium Java: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java

    Github Bonigarcia(WebdriverManager): https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager

    Cucumber Java: https://mvnrepository.com/artifact/io.cucumber/cucumber-java

    Cucumber JUnit: https://mvnrepository.com/artifact/io.cucumber/cucumber-junit

    Cucumber Reports plugins: https://plugins.jenkins.io/cucumber-reports/

- **configuration.properties:** This file is for storing and managing test data.

- **resources:** This directory is for storing features package which contains test scenarios 

  * OnlineShopping.feature: Created based on BDD by Gherkin syntax to write online shopping scenarios. More about Gherkin & Cucumber can be found at https://cucumber.io/docs/reference 

- **pages Package:** 
ShopPage and CartPage classes are placed under the package of the page to store related locators and methods based on the test steps. Both page classes inherit ReusableMethods class by using extend keyword

- **runner Package:**

    * TestRunner class: This class is for running this test script by using cucumber options which contain features package pathway, step definitions, plugins, dryRun and tags.

    * FailedTestRunner class: This class is for running failed scripts by using cucumber options which contain features package pathway, step definitions and plugins.

- **step_definitions Package:**
  
    * OnlineShoppingStepdesf class: This class is for running our scenario and steps from OnlineShopping.feature file. I created reference types of ShopPage and CartPage class objects in order to call instance methods from this class.
  
    * Hook class: this class is for running before and after each and every scenario. I have added implicitly wait and maximize screen for the UI test.
  
- **utilities Package:**
    * Driver class: it contains the Selenium web driver which I initialized for Chrome, Firefox, IE, Edge and Safari drivers
  
    * ConfigurationReader class: this class is for reading data from the configuration.properties file.
  
    * ReusableMethods class: in order to use static methods (avoiding repetitions).
  
### **Run**

Open the terminal (MAC OSX) or command prompt / power shell (for Windows OS) and navigate to the project directory type **mvn verify** or **mvn test** command to run features. With this command, it will invoke the default Chrome browser and will execute the tests. Or run from the **TestRunner** class in the project under the **runner** package.

### **Report**

Once you run your tests, the framework generates Cucumber, HTML and JSON reports, and screenshots for your tests if you enable it and also generates error shots for your failed test cases as well.

**Cucumber HTML Report:**

- **For Passed:**
![Screenshot_AllPassed](https://github.com/Fatih-gn/Online-Shopping-Automation-/assets/140351317/aedb80be-b924-4eb3-9d4a-8da28fadae9f)

- **For Failed:** I changed the expected result to 4 in the step definition to get the failed scenario's screenshot
![Screenshot_Failed](https://github.com/Fatih-gn/Online-Shopping-Automation-/assets/140351317/565fb5fe-0163-4ea5-9990-96c5102d0fe1)

**JSON Report:**
![Screenshot_JSON_Report](https://github.com/Fatih-gn/Online-Shopping-Automation-/assets/140351317/abb28554-e8c9-438a-b399-b0d74a5b92f4)

**XML Report:**
![Screenshot_XML_Report](https://github.com/Fatih-gn/Online-Shopping-Automation-/assets/140351317/5d24b5eb-ea6f-4cb3-9c97-bfbe842b4ca8)
