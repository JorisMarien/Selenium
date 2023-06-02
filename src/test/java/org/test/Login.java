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
        driver.manage().addCookie(new Cookie("rack.session", "BAh7CkkiD3Nlc3Npb25faWQGOgZFVEkiRWIyYjM5NDg5NzZmNzlhMTU1Yjc3%0AYWUzNmFiMjUzNDcyZWE5ZjEyNzZiMGU4NzBjYTY1NTI4M2FmMGNiYjRiNGMG%0AOwBGSSIJY3NyZgY7AEZJIiVkNmMyYjU1Y2QxMzFkYThiZjAyMjZlYmY5NjNl%0AOGFhMQY7AEZJIg10cmFja2luZwY7AEZ7B0kiFEhUVFBfVVNFUl9BR0VOVAY7%0AAFRJIi1jZmVkZDllYTczYWNiOWU2YmYxYjExNjE0OTFjZWYyYTA2NjYyMDc0%0ABjsARkkiGUhUVFBfQUNDRVBUX0xBTkdVQUdFBjsAVEkiLTIwZmY2ZWFjYTA1%0AN2YxMTQ4ZDdiYzRmMDQzNTY1MGVjMTI3N2FjYzAGOwBGSSIKZmxhc2gGOwBG%0AewBJIg11c2VybmFtZQY7AEZJIg10b21zbWl0aAY7AFQ%3D%0A--14f36bb3b4d6033d0d62a44eab8e32d67d3b191d"));
        driver.get("https://the-internet.herokuapp.com/secure");

        WebElement greenBannerLoginSuccess = driver.findElement(By.id("flash"));
        String loginSuccessText = greenBannerLoginSuccess.getText();
        loginSuccessText = loginSuccessText.substring(0,loginSuccessText.length()-2);
        assertEquals("You logged into a secure area!", loginSuccessText);
    }
}
