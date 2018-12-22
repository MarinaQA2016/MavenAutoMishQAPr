package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePageHelper;

public class HomePageTests extends TestBase {

  private HomePageHelper homepage;

  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    driver.get(baseUrl);
  }

  @Test
  public void openHomePageTest() {
    homepage.waitUntilPageIsLoaded();
    /*WebElement buttonLogin = driver
            .findElement(By.xpath("//span[contains(text(),'Login')]"));*/
    Assert.assertEquals(homepage.getHeaderText(),
            "Shabbat in the family circle");
  }

  @Test
  public void contentPageUnAuthTest(){
    homepage.waitUntilPageIsLoaded();
    int counter = 0;
    if (homepage.getHeaderText()
            .equals("Shabbat in the family circle")) counter++;
    if (homepage.getLoginButtonName().equals("Login")) counter++;
    if (homepage.getCreateAccountName().equals("Create Account")) counter++;
    if (homepage.getGoToEventsButtonName().equals("Go to Event list")) counter++;
    Assert.assertEquals(counter,4);
  }
}
