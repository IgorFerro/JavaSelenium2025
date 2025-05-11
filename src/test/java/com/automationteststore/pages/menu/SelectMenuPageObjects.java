package com.automationteststore.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class SelectMenuPageObjects {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public SelectMenuPageObjects(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    // Locators
    private By menMenuLocator = By.xpath("(//a[contains(text(),'Men')])[3]");
    private By skincareSubmenuLocator = By.xpath("(//a[contains(text(),'Skincare')])[3]");
    private By pageTitleLocator = By.xpath("//div[@id='maincontainer']/div/div/div/h1/span");
    private By addToCartButtons = By.xpath("//div[@id='maincontainer']//div[contains(@class,'productcart')]//a/i");
    private By cartLink = By.xpath("(//a[contains(@href, 'https://automationteststore.com/index.php?rt=checkout/cart')])[2]");

    // Actions
    public void clickMenMenu() {
        WebElement menMenu = wait.until(ExpectedConditions.elementToBeClickable(menMenuLocator));
        menMenu.click();
    }

    public void clickSkincareSubmenu() {
        WebElement skincareSubmenu = wait.until(ExpectedConditions.elementToBeClickable(skincareSubmenuLocator));
        skincareSubmenu.click();
    }

    public void clickPageTitle() {
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(pageTitleLocator));
        title.click();
    }

    public void addProductsToCart() throws InterruptedException {
        // Click page title
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@id='maincontainer']/div/div/div/h1/span")));
        title.click();
        
        // Add first 4 products
        for (int i = 1; i <= 4; i++) {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='maincontainer']/div/div/div/div/div[2]/div[" + i + "]/div[2]/div[3]/a/i")));
            addToCartButton.click();
            Thread.sleep(1000);
        }
        
        // Move to the last added product
        WebElement lastProduct = driver.findElement(
            By.xpath("//div[@id='maincontainer']/div/div/div/div/div[2]/div[3]/div[2]/div[3]/a/i"));
        actions.moveToElement(lastProduct).perform();
        
        // Move to body
        WebElement body = driver.findElement(By.tagName("body"));
        actions.moveToElement(body, 0, 0).perform();
        
        // Add the last product
        WebElement lastButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@id='maincontainer']/div/div/div/div/div[2]/div[4]/div[2]/div[3]/a/i")));
        lastButton.click();
        
        Thread.sleep(2000);
    }

    public void goToCart() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        cart.click();
    }

    // Combined action
    public void navigateToMenSkincare() {
        clickMenMenu();
        clickSkincareSubmenu();
    }

    public void completeShoppingFlow() throws InterruptedException {
        navigateToMenSkincare();
        clickPageTitle();
        addProductsToCart();
        goToCart();
    }
}
