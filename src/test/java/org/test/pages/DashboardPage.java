package org.test.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By greenSuccessBanner = By.id("flash");
    By logoutButton = By.className("icon-signout");

    public void checkGreenBanner() {
        String loginSuccessText = driver.findElement(greenSuccessBanner).getText();
        loginSuccessText = loginSuccessText.substring(0, loginSuccessText.length() - 2);
        Assert.assertEquals("You logged into a secure area!", loginSuccessText);
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
