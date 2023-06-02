package org.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Login {
    WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setup(){
        driver.get("https://the-internet.herokuapp.com/login");
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }
    @Test
    public void loginTest(){
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        WebElement textBoxUsername = driver.findElement(By.id("username"));
        WebElement textBoxPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        textBoxUsername.sendKeys(username);
        textBoxPassword.sendKeys(password);
        loginButton.click();

        WebElement greenBannerLoginSuccess = driver.findElement(By.id("flash"));
        String loginSuccessText = greenBannerLoginSuccess.getText();
        loginSuccessText = loginSuccessText.substring(0,loginSuccessText.length()-2);
        assertEquals("You logged into a secure area!", loginSuccessText);


        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        logoutButton.click();
    }
    @Test
    public void loginCookieTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        WebElement textBoxUsername = driver.findElement(By.id("username"));
        WebElement textBoxPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        textBoxUsername.sendKeys(username);
        textBoxPassword.sendKeys(password);

        loginButton.click();
        Cookie loginCookie = driver.manage().getCookieNamed("rack.session");
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        logoutButton.click();
        driver.manage().deleteCookieNamed("rack.session");
        driver.manage().addCookie(loginCookie);
        driver.get("https://the-internet.herokuapp.com/secure");
        WebElement textSecurePage = driver.findElement(By.className("subheader"));
        assertEquals("Welcome to the Secure Area. When you are done click logout below.", textSecurePage.getText());
    }
}
