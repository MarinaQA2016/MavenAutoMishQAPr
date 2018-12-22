package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a PageBase in the UI. PageBase object pattern
 */
public abstract class PageBase {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public PageBase(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public static void waitUntilElementIsLoaded(
          WebDriver driver, By locator, int time) {
    try {
      new WebDriverWait(driver, time)
              .until(ExpectedConditions
                      .visibilityOfElementLocated(locator));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitUntilElementIsLoaded(
          WebDriver driver, WebElement element, int time) {
    try {
      new WebDriverWait(driver, time)
              .until(ExpectedConditions
                      .visibilityOf(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
