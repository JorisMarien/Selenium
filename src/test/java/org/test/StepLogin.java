package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.pages.DashboardPage;
import org.test.pages.LoginPage;


public class StepLogin {
    WebDriver driver = new ChromeDriver();
    LoginPage login = new LoginPage(driver);
    DashboardPage dashboard = new DashboardPage(driver);

    @Given("I am on the login page")
    public void setup() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I type {string} and {string}")
    public void login(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
    }

    @Then("There is a green banner with success")
    public void loggedIn() {
        dashboard.checkGreenBanner();
        dashboard.logout();
    }
}
