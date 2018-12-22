package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;

/**
 * Created by Inka on 21-Dec-18.
 */
public class LoginPageTests extends TestBase {

    private HomePageHelper homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        driver.get(baseUrl);
    }

    @Test
    public void loginPositive(){
        homepage.waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Go to Event list')]"), 30);
        WebElement buttonLogin = driver
                .findElement(By.xpath("//span[contains(text(),'Login')]"));
        buttonLogin.click();
        homepage.waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Cancel')]"), 30);
        WebElement emailField = driver
                .findElement(By.xpath("//input[@type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("marina@123.com");
        WebElement passwordField = driver
                .findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marina");
        /*waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Log in')]"),20);*/
        WebElement submitButton = driver.
                //findElement(By.xpath("//span[contains(text(),'Log in')]"));
                        findElement(By.xpath("//button[@type='submit']"));
        Actions action = new Actions(driver);
        action.moveToElement(submitButton).build().perform();
        submitButton.click();
        /*waitUntilElementIsLoaded(driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),30);*/
        WebElement icon = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        System.out.println("icon: " + icon.getAttribute("mattooltip"));
        Assert.assertTrue(icon.getAttribute("mattooltip").equals("Menu"));
    }
}
