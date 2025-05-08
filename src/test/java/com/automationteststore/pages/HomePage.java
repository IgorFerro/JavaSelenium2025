package com.automationteststore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "ul.nav-pills li a[href*='account']")
    private WebElement accountLink;

    @FindBy(css = "ul.nav-pills li a[href*='login']")
    private WebElement loginLink;

    @FindBy(css = "ul.categories")
    private WebElement categoriesMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        waitForElementToBeClickable(accountLink);
        accountLink.click();
        waitForElementToBeClickable(loginLink);
        loginLink.click();
    }

    public boolean isCategoriesMenuDisplayed() {
        waitForElementToBeVisible(categoriesMenu);
        return categoriesMenu.isDisplayed();
    }
} 