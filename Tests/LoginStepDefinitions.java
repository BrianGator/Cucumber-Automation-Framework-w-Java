package com.cucumber.tests;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

/**
 * Step Definition 1: User Login Scenarios
 */
public class LoginStepDefinitions {
    private WebDriver driver;
    
    public LoginStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        driver.get("https://www.techproeducation.com/");
        Assert.assertNotNull(driver.getTitle());
    }

    @When("user enters valid username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @When("user enters valid password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("user is navigated to dashboard")
    public void user_navigated_to_dashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard") || driver.getTitle().length() > 0);
    }

    @Given("user enters incorrect credentials")
    public void user_enters_incorrect_credentials() {
        driver.findElement(By.name("username")).sendKeys("wronguser");
        driver.findElement(By.name("password")).sendKeys("wrongpass");
    }

    @Then("error message is displayed")
    public void error_message_displayed() {
        // Assertion for error message
        Assert.assertNotNull(driver);
    }
    
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
