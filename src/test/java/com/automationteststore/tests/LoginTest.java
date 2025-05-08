package com.automationteststore.tests;

import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testHomePageNavigation() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isCategoriesMenuDisplayed(), "Categories menu should be displayed");
    }

    @Test
    public void testLoginNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "testpass");
        // Add assertions based on expected behavior after login
    }
} 