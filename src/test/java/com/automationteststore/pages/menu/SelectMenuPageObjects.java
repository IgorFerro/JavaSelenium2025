package com.automationteststore.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

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
        // Wait for products to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".productcart")));
        
        // Find all add to cart buttons
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".productcart a[title='Add to Cart']"));
        System.out.println("Found " + addToCartButtons.size() + " products to add to cart");
        
        // Add products to cart
        for (int i = 0; i < addToCartButtons.size(); i++) {
            try {
                // Scroll to element
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButtons.get(i));
                Thread.sleep(1000); // Wait for scroll
                
                // Click using JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButtons.get(i));
                System.out.println("Added product " + (i + 1) + " to cart");
                
                // Wait for cart update
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Could not add product " + (i + 1) + " to cart: " + e.getMessage());
            }
        }
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
