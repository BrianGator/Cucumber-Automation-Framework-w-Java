# Cucumber Automation Framework with Java

A robust and scalable **Behavior Driven Development (BDD)** test automation framework built with **Cucumber** and **Java**. This framework enables writing and executing automated tests in plain English using Gherkin syntax, making test cases understandable to both technical and non-technical stakeholders.

## 📋 Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Pre-requisites](#pre-requisites)
- [Project File Structure](#project-file-structure)
- [Cucumber Methodologies Covered](#cucumber-methodologies-covered)
- [Languages & Technologies](#languages--technologies)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Contributing](#contributing)

---

## Overview

This Cucumber Automation Framework is designed for **web application test automation** using the BDD approach. It provides a comprehensive structure for organizing test scenarios, step definitions, and page objects, following best practices for maintainability and scalability.

**Framework Benefits:**
- 🎯 **Clear Test Scenarios**: Write tests in Gherkin language readable by all stakeholders
- 🔄 **Reusable Components**: Leverage page objects and step definitions across multiple tests
- 📊 **Detailed Reporting**: Generate comprehensive test reports
- 🛠️ **Easy Maintenance**: Well-organized code structure for easy updates and debugging
- 🌐 **Cross-browser Support**: Execute tests on multiple browsers
- ⚡ **Parallel Execution**: Run tests in parallel for faster feedback

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

---

## Resources

- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Gherkin Syntax Guide](https://cucumber.io/docs/gherkin/)

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
**Framework Version**: 1.0.0  
**Java Version**: 8+  
**Cucumber Version**: 7.x+
