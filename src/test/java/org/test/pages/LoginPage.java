package org.test.pages;


import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.id("username");
    By password = By.id("password");
    By loginButton = By.className("fa-sign-in");

    public void enterUsername(String user) {
        driver.findElement(userName).sendKeys(user);
    }

    public void enterPassword(String pswd) {
        driver.findElement(password).sendKeys(pswd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
