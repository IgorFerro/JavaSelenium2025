package com.automationteststore.pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;

public class SelectMenuPageFactory {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SelectMenuPageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy
    @FindBy(xpath = "(//a[contains(text(),'Men')])[3]")
    private WebElement menMenu;

    @FindBy(xpath = "(//a[contains(text(),'Skincare')])[3]")
    private WebElement skincareSubmenu;

    @FindBy(xpath = "//div[@id='maincontainer']/div/div/div/h1/span")
    private WebElement pageTitle;

    @FindBy(xpath = "(//a[contains(@href, 'https://automationteststore.com/index.php?rt=checkout/cart')])[2]")
    private WebElement cartLink;

    // Actions
    public void clickMenMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menMenu)).click();
    }

    public void clickSkincareSubmenu() {
        wait.until(ExpectedConditions.elementToBeClickable(skincareSubmenu)).click();
    }

    public void clickPageTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(pageTitle)).click();
    }

    public void addProductsToCart() throws InterruptedException {
        // Click page title
        clickPageTitle();
        
        // Add first 4 products
        for (int i = 1; i <= 4; i++) {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='maincontainer']/div/div/div/div/div[2]/div[" + i + "]/div[2]/div[3]/a/i")));
            addToCartButton.click();
            Thread.sleep(1000);
        }
        
        // Add the last product
        WebElement lastButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@id='maincontainer']/div/div/div/div/div[2]/div[4]/div[2]/div[3]/a/i")));
        lastButton.click();
        
        Thread.sleep(2000);
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    // Combined action
    public void completeShoppingFlow() throws InterruptedException {
        clickMenMenu();
        clickSkincareSubmenu();
        clickPageTitle();
        addProductsToCart();
        goToCart();
    }
} 