package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Login {
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement textBoxUsername = driver.findElement(By.id("username"));
        WebElement textBoxPassword = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));

        textBoxUsername.sendKeys("tomsmith");
        textBoxPassword.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement greenBannerLoginSuccess = driver.findElement(By.id("flash"));
        String loginSuccessText = greenBannerLoginSuccess.getText();
        loginSuccessText = loginSuccessText.substring(0,loginSuccessText.length()-2);
        assertEquals("You logged into a secure area!", loginSuccessText);

        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        logoutButton.click();

        driver.quit();
    }

}
