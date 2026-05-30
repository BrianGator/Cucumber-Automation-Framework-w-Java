# Cucumber Automation Framework with Java

A robust and scalable **Behavior Driven Development (BDD)** test automation framework built with **Cucumber** and **Java**. This framework enables writing and executing automated tests in plain English, making testing more collaborative and maintainable.

## 📋 Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Pre-requisites](#pre-requisites)
- [Project File Structure](#project-file-structure)
- [Cucumber Methodologies Covered](#cucumber-methodologies-covered)
- [Languages & Technologies](#languages--technologies)
- [Cucumber Coding Examples & Guide](#cucumber-coding-examples--guide)
  - [Feature Files](#feature-files)
  - [Step Definitions](#step-definitions)
  - [Page Object Model](#page-object-model)
  - [Hooks & Configuration](#hooks--configuration)
  - [Data-Driven Testing](#data-driven-testing)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [Troubleshooting](#troubleshooting)
- [Resources](#resources)

---

## Overview

This Cucumber Automation Framework is designed for **web application test automation** using the BDD approach. It provides a comprehensive structure for organizing test scenarios, step definitions, and page objects while maintaining code quality and reusability.

**Framework Benefits:**
- 🎯 **Clear Test Scenarios**: Write tests in Gherkin language readable by all stakeholders
- 🔄 **Reusable Components**: Leverage page objects and step definitions across multiple tests
- 📊 **Detailed Reporting**: Generate comprehensive test reports
- 🛠️ **Easy Maintenance**: Well-organized code structure for easy updates and debugging
- 🌐 **Cross-browser Support**: Execute tests on multiple browsers
- ⚡ **Parallel Execution**: Run tests in parallel for faster feedback

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Key Features

### ✨ Core Features
- **Cucumber Integration**: BDD framework for writing human-readable test scenarios
- **Page Object Model (POM)**: Encapsulate web elements and interactions in page classes
- **Selenium WebDriver**: Industry-standard web automation library
- **TestNG**: Powerful testing framework with advanced reporting
- **Maven**: Build and dependency management
- **Parallel Test Execution**: Run multiple tests concurrently
- **Comprehensive Logging**: Detailed logs for debugging and analysis
- **Screenshot Capture**: Automatic screenshot capture on test failures
- **Cross-browser Testing**: Support for Chrome, Firefox, Safari, and Edge browsers

### 🎯 BDD Advantages
- Scenarios written in plain English (Gherkin syntax)
- Easy collaboration between QA, Developers, and Business Analysts
- Living documentation of application behavior
- Reduced gaps between requirements and testing

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Pre-requisites

### System Requirements
- **Operating System**: Windows, macOS, or Linux
- **RAM**: Minimum 4GB (8GB recommended)
- **Storage**: At least 1GB free space

### Software Requirements
- **Java Development Kit (JDK)**: Version 8 or higher
  - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.java.net/)
- **Maven**: Version 3.6.0 or higher
  - Download: [Apache Maven](https://maven.apache.org/download.cgi)
- **Git**: For version control
  - Download: [Git](https://git-scm.com/)
- **IDE** (Optional but recommended):
  - IntelliJ IDEA Community Edition
  - Eclipse IDE
  - Visual Studio Code

### Browser Drivers
- **ChromeDriver**: For Google Chrome browser
- **GeckoDriver**: For Mozilla Firefox browser
- **SafariDriver**: For Apple Safari browser (macOS)
- **EdgeDriver**: For Microsoft Edge browser

*Note: WebDriver executables are included in the `/webdrivers` directory*

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Project File Structure

```
Cucumber-Automation-Framework-w-Java/
│
├── src/                                    # Source code directory
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── automation/
│   │   │           ├── pages/             # Page Object Model classes
│   │   │           │   ├── BasePage.java
│   │   │           │   ├── HomePage.java
│   │   │           │   ├── LoginPage.java
│   │   │           │   └── [...other pages]
│   │   │           ├── utils/             # Utility classes
│   │   │           │   ├── DriverFactory.java
│   │   │           │   ├── ConfigReader.java
│   │   │           │   ├── WaitUtils.java
│   │   │           │   └── TestDataUtil.java
│   │   │           ├── listeners/         # TestNG Listeners
│   │   │           │   └── TestListener.java
│   │   │           └── constants/         # Constants and configurations
│   │   │               └── Constants.java
│   │   └── resources/
│   │       ├── config.properties          # Configuration file
│   │       ├── testdata.properties        # Test data
│   │       └── log4j.properties           # Logging configuration
│   │
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── automation/
│       │           ├── steps/             # Step Definition classes
│       │           │   ├── BaseSteps.java
│       │           │   ├── LoginSteps.java
│       │           │   ├── HomeSteps.java
│       │           │   └── [...other steps]
│       │           └── runners/           # Test Runner classes
│       │               └── TestRunner.java
│       └── resources/
│           └── features/
│               ├── login.feature         # Feature files (Gherkin scenarios)
│               ├── home.feature
│               └── [...other features]
│
├── features/                              # Alternative feature files location
│   └── [.feature files]
│
├── webdrivers/                            # WebDriver executables
│   ├── chromedriver
│   ├── geckodriver
│   ├── msedgedriver
│   └── safaridriver
│
├── pom.xml                                # Maven configuration file
├── .gitignore                             # Git ignore file
├── README.md                              # Project documentation
└── target/                                # Build output (generated)
    └── cucumber-reports/                 # Test reports
```

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Cucumber Methodologies Covered

### 1. **Feature Files (Gherkin Syntax)**
   - Written in plain English for non-technical stakeholders
   - Location: `src/test/resources/features/`
   - Structure: `Feature → Scenario → Given/When/Then`

### 2. **Scenario Outlines**
   - Parameterized test execution with multiple data sets
   - Reduces code duplication for similar tests
   ```gherkin
   Scenario Outline: User login with multiple credentials
     Given User is on login page
     When User enters <username> and <password>
     Then User is logged in as <name>
   ```

### 3. **Step Definitions**
   - Java implementation of Gherkin steps
   - Location: `src/test/java/com/automation/steps/`
   - Mapped using annotations: `@Given`, `@When`, `@Then`, `@And`, `@But`

### 4. **Page Object Model (POM)**
   - Encapsulates web page elements and actions
   - Improves maintainability and reduces duplication
   - Location: `src/main/java/com/automation/pages/`

### 5. **Hooks**
   - Setup and teardown operations
   - `@Before`: Executes before each scenario
   - `@After`: Executes after each scenario
   - Used for browser initialization, driver cleanup, screenshots on failure

### 6. **Tags**
   - Categorize scenarios for selective execution
   - Examples: `@smoke`, `@regression`, `@sanity`, `@critical`
   - Execute tagged scenarios: `mvn test -Dcucumber.filter.tags="@smoke"`

### 7. **Data-Driven Testing**
   - External data sources (Excel, CSV, databases)
   - Scenario Outlines for parameter-driven tests
   - Enables testing with multiple datasets

### 8. **Background Scenarios**
   - Common steps executed before each scenario in a feature file
   - Reduces repetitive setup code

### 9. **Step Expressions**
   - Regular expressions for flexible step matching
   - Data table support for complex parameter passing

### 10. **Cucumber Reports**
   - HTML, JSON, and XML report generation
   - Integration with CI/CD pipelines
   - Real-time test status tracking

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Languages & Technologies

### **Primary Languages**
- **Java** (87.9%) - Core automation logic and framework
- **Gherkin** (12.1%) - Test scenario definitions

### **Testing & Automation Stack**

| Technology | Purpose | Version |
|-----------|---------|---------|
| **Cucumber** | BDD Framework | 7.x+ |
| **Selenium WebDriver** | Web Automation | 4.x+ |
| **TestNG** | Test Framework | 7.x+ |
| **Maven** | Build Tool | 3.6.0+ |
| **Java** | Programming Language | 8+ |
| **Log4j** | Logging | 2.x |
| **Apache Commons** | Utilities | 3.x |
| **Picocontainer** | Dependency Injection | 2.x |

### **Supported Browsers**
- ✅ Google Chrome
- ✅ Mozilla Firefox
- ✅ Microsoft Edge
- ✅ Apple Safari

### **Note on C#**
While this framework is built with **Java**, Cucumber also supports **C#** development:
- **SpecFlow**: Cucumber implementation for .NET/C#
- **Selenium WebDriver for C#**: For web automation in C#
- **NUnit/xUnit**: Testing frameworks for C#

If you require a C# version of this framework, consider exploring SpecFlow for BDD testing in .NET environments.

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Cucumber Coding Examples & Guide

This section provides practical examples and best practices for implementing Cucumber tests in Java.

### Feature Files

**Location**: `src/test/resources/features/login.feature`

A feature file contains scenarios written in Gherkin syntax. Here's a comprehensive example:

```gherkin
Feature: User Login Functionality
  As a user
  I want to login to the application
  So that I can access my account

  Background:
    Given User navigates to login page
    And User waits for login form to be visible

  @smoke @critical
  Scenario: Successful login with valid credentials
    When User enters username "testuser@example.com"
    And User enters password "SecurePassword123"
    And User clicks login button
    Then User should see welcome message "Welcome, Test User"
    And User should be redirected to home page

  @smoke
  Scenario: Login fails with invalid credentials
    When User enters username "invalid@example.com"
    And User enters password "WrongPassword"
    And User clicks login button
    Then User should see error message "Invalid username or password"
    And User should remain on login page

  @regression
  Scenario Outline: Login with multiple credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then User should see message "<expectedMessage>"

    Examples:
      | username              | password           | expectedMessage                    |
      | validuser@example.com | ValidPass123       | Welcome, Valid User                |
      | emptyuser@example.com |                    | Password is required               |
      |                       | SomePassword       | Email/username is required         |
```

**Key Gherkin Elements**:
- `Feature`: Describes what is being tested
- `Background`: Common setup steps for all scenarios
- `Scenario`: Individual test case
- `Scenario Outline`: Parameterized test with multiple data sets
- `@Tags`: Used for test categorization and filtering
- `Given/When/Then/And/But`: Step keywords (order matters for readability)

[⬆ Back to Table of Contents](#-table-of-contents)

### Step Definitions

**Location**: `src/test/java/com/automation/steps/LoginSteps.java`

Step definitions are the Java implementation of Gherkin steps. They map text from feature files to executable code:

```java
package com.automation.steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.automation.pages.LoginPage;
import com.automation.pages.HomePage;
import com.automation.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {
    
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    
    @Before
    public void setUp() {
        logger.info("Setting up WebDriver for test execution");
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    
    @After
    public void tearDown() {
        logger.info("Tearing down WebDriver after test execution");
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        logger.info("User is navigating to login page");
        loginPage.navigateToLoginPage();
    }
    
    @And("User waits for login form to be visible")
    public void userWaitsForLoginFormToBeVisible() {
        logger.info("Waiting for login form to be visible");
        loginPage.waitForLoginFormToBeVisible();
    }
    
    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        logger.info("User enters username: " + username);
        loginPage.enterUsername(username);
    }
    
    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        logger.info("User enters password");
        loginPage.enterPassword(password);
    }
    
    @When("User clicks login button")
    public void userClicksLoginButton() {
        logger.info("User clicks login button");
        loginPage.clickLoginButton();
    }
    
    @Then("User should see welcome message {string}")
    public void userShouldSeeWelcomeMessage(String expectedMessage) {
        logger.info("Verifying welcome message: " + expectedMessage);
        String actualMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Welcome message does not match");
    }
    
    @Then("User should be redirected to home page")
    public void userShouldBeRedirectedToHomePage() {
        logger.info("Verifying user is on home page");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/home"), 
            "User is not redirected to home page");
    }
    
    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedError) {
        logger.info("Verifying error message: " + expectedError);
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, 
            "Error message does not match");
    }
    
    @Then("User should remain on login page")
    public void userShouldRemainOnLoginPage() {
        logger.info("Verifying user is still on login page");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), 
            "User navigated away from login page");
    }
    
    @Then("User should see message {string}")
    public void userShouldSeeMessage(String expectedMessage) {
        logger.info("Verifying message: " + expectedMessage);
        String actualMessage = null;
        
        if (expectedMessage.startsWith("Welcome")) {
            actualMessage = homePage.getWelcomeMessage();
        } else {
            actualMessage = loginPage.getErrorMessage();
        }
        
        Assert.assertEquals(actualMessage, expectedMessage, 
            "Expected message not found");
    }
}
```

**Best Practices for Step Definitions**:
- Each step should do ONE thing
- Use descriptive method names matching the Gherkin text
- Employ proper logging for debugging
- Keep assertions within step definitions
- Use meaningful variable names
- Handle waits appropriately
- Avoid hardcoding values (use parameters instead)

[⬆ Back to Table of Contents](#-table-of-contents)

### Page Object Model

**Location**: `src/main/java/com/automation/pages/LoginPage.java`

The Page Object Model (POM) encapsulates page elements and interactions:

```java
package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;

public class LoginPage extends BasePage {
    
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators using @FindBy annotation
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "loginButton")
    private WebElement loginButton;
    
    @FindBy(className = "error-message")
    private WebElement errorMessage;
    
    @FindBy(id = "loginForm")
    private WebElement loginForm;
    
    // Alternative locators using By
    private By usernameBY = By.id("username");
    private By passwordBY = By.id("password");
    private By loginButtonBY = By.id("loginButton");
    private By errorMessageBY = By.className("error-message");
    
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    // Page Actions
    public void navigateToLoginPage() {
        logger.info("Navigating to login page");
        driver.get("https://your-app-url.com/login");
    }
    
    public void waitForLoginFormToBeVisible() {
        logger.info("Waiting for login form to be visible");
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }
    
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        logger.info("Entering password");
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLoginButton() {
        logger.info("Clicking login button");
        loginButton.click();
    }
    
    public String getErrorMessage() {
        logger.info("Fetching error message");
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
    
    public boolean isErrorMessageDisplayed() {
        logger.info("Checking if error message is displayed");
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (Exception e) {
            logger.warn("Error message not displayed");
            return false;
        }
    }
    
    // Combined action methods
    public void loginWithCredentials(String username, String password) {
        logger.info("Logging in with credentials");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
```

**BasePage Class** - Common functionality for all pages:

```java
package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    
    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public void scrollToElement(WebDriver driver, WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void waitForPageLoad() {
        jsExecutor.executeScript("return document.readyState").equals("complete");
    }
}
```

**POM Best Practices**:
- One Page Object class per page/component
- Locators should be private and organized
- Public methods represent user actions
- Use explicit waits for elements
- Extend a base page for common functionality
- Keep page objects independent
- Use meaningful method names

[⬆ Back to Table of Contents](#-table-of-contents)

### Hooks & Configuration

**Location**: `src/test/java/com/automation/steps/Hooks.java`

Hooks provide setup and teardown functionality for scenarios:

```java
package com.automation.steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import com.automation.utils.DriverFactory;
import com.automation.utils.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private WebDriver driver;
    
    @Before(order = 1)
    public void setUp() {
        logger.info("====== Test Execution Started ======");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        logger.info("Browser launched and window maximized");
    }
    
    @Before(value = "@loginRequired", order = 2)
    public void loginSetup() {
        logger.info("Additional setup for login required scenarios");
        // Add additional setup for login scenarios
    }
    
    @After
    public void tearDown(Scenario scenario) {
        logger.info("====== Test Execution Completed ======");
        
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            
            if (ConfigReader.getConfigValue("screenshot.on.failure").equals("true")) {
                captureScreenshot(scenario.getName());
            }
        } else {
            logger.info("Scenario passed: " + scenario.getName());
        }
        
        // Close browser
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
    
    private void captureScreenshot(String scenarioName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String destination = "target/screenshots/" + scenarioName + "_" + timestamp + ".png";
            
            FileUtils.copyFile(source, new File(destination));
            logger.info("Screenshot captured: " + destination);
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
```

**Configuration Reader**:

```java
package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties;
    private static final String CONFIG_FILE = 
        "src/main/resources/config.properties";
    
    static {
        try {
            FileInputStream fileInputStream = 
                new FileInputStream(CONFIG_FILE);
            properties = new Properties();
            properties.load(fileInputStream);
            logger.info("Configuration loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration: " + e.getMessage());
        }
    }
    
    public static String getConfigValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Configuration key not found: " + key);
        }
        return value;
    }
}
```

**Configuration File** (`src/main/resources/config.properties`):

```properties
# Application URLs
base.url=https://your-application-url.com
login.url=https://your-application-url.com/login

# Browser Configuration
browser=chrome
headless.mode=false

# Wait Times (in seconds)
implicit.wait=10
explicit.wait=15

# Screenshot Settings
screenshot.on.failure=true

# Logging
log.level=INFO

# Test Data
test.username=testuser@example.com
test.password=TestPassword123
```

[⬆ Back to Table of Contents](#-table-of-contents)

### Data-Driven Testing

**Feature File with Data Tables**:

```gherkin
Feature: User Registration with Data Tables

  @datadriven
  Scenario: Register user with multiple fields
    Given User is on registration page
    When User fills in the registration form with the following data:
      | firstName | John          |
      | lastName  | Doe           |
      | email     | john@example.com |
      | password  | SecurePass123 |
      | country   | United States |
    Then User should be registered successfully
    And Confirmation email should be sent to "john@example.com"

  @scenariooutline
  Scenario Outline: Register users with different data
    Given User is on registration page
    When User enters first name "<firstName>"
    And User enters last name "<lastName>"
    And User enters email "<email>"
    And User enters password "<password>"
    And User submits registration form
    Then Registration status should be "<status>"

    Examples:
      | firstName | lastName | email               | password      | status    |
      | John      | Doe      | john@example.com    | SecurePass123 | Success   |
      | Jane      | Smith    | jane@example.com    | Password@1    | Success   |
      | Bob       | Johnson  | bob.example.com     | Pass123       | Invalid   |
      | Alice     | Brown    | alice@example.com   | 12345         | Weak      |
```

**Step Definition with Data Tables**:

```java
package com.automation.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import com.automation.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.util.Map;

public class RegistrationSteps {
    
    private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);
    private RegistrationPage registrationPage;
    
    @When("User fills in the registration form with the following data:")
    public void userFillsRegistrationFormWithData(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        logger.info("Filling registration form with data");
        registrationPage.enterFirstName(data.get("firstName"));
        registrationPage.enterLastName(data.get("lastName"));
        registrationPage.enterEmail(data.get("email"));
        registrationPage.enterPassword(data.get("password"));
        registrationPage.selectCountry(data.get("country"));
        registrationPage.submitForm();
    }
    
    @Then("Confirmation email should be sent to {string}")
    public void confirmationEmailShouldBeSentTo(String email) {
        logger.info("Verifying confirmation email sent to: " + email);
        // Implementation to verify email was sent
    }
}
```

**External Data Source (Excel)**:

```java
package com.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {
    
    private static final Logger logger = LogManager.getLogger(ExcelReader.class);
    
    public static List<Map<String, String>> getTestData(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowData = new HashMap<>();
                
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = row.getCell(j).getStringCellValue();
                    rowData.put(key, value);
                }
                
                data.add(rowData);
            }
            
            logger.info("Test data loaded from Excel: " + filePath);
        } catch (IOException e) {
            logger.error("Failed to read Excel file: " + e.getMessage());
        }
        
        return data;
    }
}
```

**Data-Driven Testing Best Practices**:
- Use Scenario Outlines for multiple similar tests
- Keep test data external (Excel, CSV, databases)
- Use Data Tables for complex data structures
- Maintain data consistency and validity
- Document data dependencies

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Setup & Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/BrianGator/Cucumber-Automation-Framework-w-Java.git
cd Cucumber-Automation-Framework-w-Java
```

### Step 2: Verify Java Installation
```bash
java -version
javac -version
```

### Step 3: Verify Maven Installation
```bash
mvn -version
```

### Step 4: Update Project Dependencies
```bash
mvn clean install
```

### Step 5: Configure Application Under Test (AUT)
Update `src/main/resources/config.properties`:
```properties
# Base URL of the application
base.url=https://your-application-url.com

# Browser selection
browser=chrome

# Wait times
implicit.wait=10
explicit.wait=15

# Screenshot on failure
screenshot.on.failure=true

# Headless mode
headless.mode=false
```

### Step 6: Setup WebDrivers
Ensure WebDriver executables are in the `/webdrivers` directory:
- **Windows**: chromedriver.exe, geckodriver.exe, msedgedriver.exe
- **macOS/Linux**: chromedriver, geckodriver, safaridriver

Or install via WebDriver Manager dependency (handles downloads automatically).

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Feature File
```bash
mvn test -Dcucumber.features="src/test/resources/features/login.feature"
```

### Run Tests with Specific Tags
```bash
# Run only @smoke tagged tests
mvn test -Dcucumber.filter.tags="@smoke"

# Run @smoke OR @critical
mvn test -Dcucumber.filter.tags="@smoke or @critical"

# Run @regression AND NOT @wip
mvn test -Dcucumber.filter.tags="@regression and not @wip"
```

### Run Tests in Parallel
```bash
mvn test -DthreadCount=4
```

### Generate Cucumber Report
```bash
mvn test
```
Reports generated in: `target/cucumber-reports/`

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/your-feature-name`
3. **Commit your changes**: `git commit -m "Add your commit message"`
4. **Push to the branch**: `git push origin feature/your-feature-name`
5. **Submit a Pull Request**

### Code Standards
- Follow Java naming conventions
- Write descriptive step definitions
- Use Page Object Model for UI interactions
- Add appropriate comments and documentation
- Keep feature files simple and focused

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Troubleshooting

### Common Issues

**Issue**: WebDriver not found
- **Solution**: Ensure WebDriver executables are in `/webdrivers` directory or use WebDriver Manager

**Issue**: Tests fail with "Element not found"
- **Solution**: Increase wait times in `config.properties`

**Issue**: Maven build fails
- **Solution**: Run `mvn clean install` and check Java/Maven versions

**Issue**: Feature file not recognized
- **Solution**: Verify feature files are in `src/test/resources/features/`

[⬆ Back to Table of Contents](#-table-of-contents)

---

## Resources

- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Gherkin Syntax Guide](https://cucumber.io/docs/gherkin/)
- [Java Regular Expressions](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/Pattern.html)
- [Log4j2 Configuration](https://logging.apache.org/log4j/2.x/manual/configuration.html)

[⬆ Back to Table of Contents](#-table-of-contents)

---

## License

This project is open source and available under the MIT License.

---

## Contact & Support

For questions, issues, or suggestions, please:
- Open an Issue in the GitHub repository
- Contact the repository maintainer

---

**Last Updated**: May 2026  
**Framework Version**: 1.1.0  
**Java Version**: 8+  
**Cucumber Version**: 7.x+
