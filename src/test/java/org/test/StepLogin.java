package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepLogin {
    WebDriver driver = new ChromeDriver();
    @Given("I am on the log in page")
    public void setup(){
        driver.get("https://the-internet.herokuapp.com/login");
    }
    @When("I typ the correct credentials")
    public void login(){
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        WebElement textBoxUsername = driver.findElement(By.id("username"));
        WebElement textBoxPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        textBoxUsername.sendKeys(username);
        textBoxPassword.sendKeys(password);
        loginButton.click();
    }

    @Then("Then there is a green banner with success")
    public void loggedIn(){
        WebElement greenBannerLoginSuccess = driver.findElement(By.id("flash"));
        String loginSuccessText = greenBannerLoginSuccess.getText();
        loginSuccessText = loginSuccessText.substring(0,loginSuccessText.length()-2);
        assertEquals("You logged into a secure area!", loginSuccessText);
    }
}
