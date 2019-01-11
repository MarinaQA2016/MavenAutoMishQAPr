package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.AuthEventsPageHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.MenuPageHelper;

/**
 * Created by Inka on 21-Dec-18.
 */
public class LoginPageTests extends TestBase {

    private HomePageHelper homepage;
    private LoginPageHelper loginPage;
    private AuthEventsPageHelper authEventsPage;
    private MenuPageHelper menuPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver,
                HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,
                LoginPageHelper.class);
        authEventsPage = PageFactory.initElements(driver,
                AuthEventsPageHelper.class);
        menuPage = PageFactory.initElements(driver,
                MenuPageHelper.class);
        driver.get(baseUrl);
        homepage.waitUntilPageIsLoaded()
                .pressLoginButton();
        loginPage.waitUntilPageIsLoaded();

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorization")
    public void loginPositive(String email, String password){
        loginPage.enterEmail(email)
                .enterPassword(password)
                .pressSubmitButton();
        authEventsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(authEventsPage.isHeaderCorrect("Find event"));
        Assert.assertTrue(authEventsPage.isDisplayedIconMenu());
        authEventsPage.pressIconMenu();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
    }
}
