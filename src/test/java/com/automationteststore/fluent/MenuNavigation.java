package com.automationteststore.fluent;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.List;
    
public class MenuNavigation {

    private final WebDriver     driver;
    private final WebDriverWait wait;
    private final Actions       actions;

    public MenuNavigation(WebDriver driver) {
        this.driver  = driver;
        this.wait    = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    /* ------------- locators ------------- */

    private By desktopBar()   { return By.cssSelector("ul.nav-pills.categorymenu"); }
    private By burgerButton() { return By.cssSelector("button.navbar-toggle"); }

    /* Updated main menu locator with more robust XPath */
    private By main(String t) {
        return By.xpath(
            "//ul[contains(@class,'categorymenu')]" +
            "//a[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + 
            t.toLowerCase() + "')]");
    }

    /* Updated submenu locator with more robust XPath */
    private By sub(String p, String c) {
        return By.xpath(
            "//ul[contains(@class,'categorymenu')]" +
            "//li[.//a[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + p.toLowerCase() + "')]]" +
            "//a[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + c.toLowerCase() + "')]");
    }

    /* ------------- helpers -------------- */

    private void ensureMenuVisible() throws InterruptedException {
        try {
            // Wait for page to be fully loaded
            waitForPageLoad();
            
            // First check if menu is already visible
            if (driver.findElements(desktopBar()).stream().anyMatch(WebElement::isDisplayed)) {
                System.out.println("Desktop menu is already visible");
                return;
            }

            // If not visible, try to click the burger menu
            System.out.println("Attempting to open burger menu");
            WebElement burger = wait.until(
                    ExpectedConditions.elementToBeClickable(burgerButton()));
            burger.click();
            
            // Wait for menu to be visible
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(desktopBar()));
            System.out.println("Menu is now visible: " + menu.isDisplayed());
            
            // Add a small delay to ensure menu is fully loaded
            Thread.sleep(1000);
            
            printAllMenus();
        } catch (Exception e) {
            System.out.println("Error ensuring menu visibility: " + e.getMessage());
            throw e;
        }
    }

    /* ------------- public API ----------- */

    public MenuNavigation clickMain(String text) throws InterruptedException {
        try {
            ensureMenuVisible();
            System.out.println("Attempting to click menu: " + text);
            
            // Try to find and click the menu using JavaScript if regular click fails
            try {
                WebElement m = wait.until(ExpectedConditions.elementToBeClickable(main(text)));
                System.out.println("Found menu element: " + m.getText());
                m.click();
            } catch (Exception e) {
                System.out.println("Regular click failed, trying JavaScript click");
                WebElement m = wait.until(ExpectedConditions.presenceOfElementLocated(main(text)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", m);
            }
            
            // Wait for any animations to complete
            Thread.sleep(1000);
            return this;
        } catch (Exception e) {
            System.out.println("Error clicking main menu: " + e.getMessage());
            throw e;
        }
    }

    public MenuNavigation clickSub(String parent, String child) throws InterruptedException {
        try {
            System.out.println("Attempting to click submenu: " + child + " under " + parent);
            
            // Try to find and click the submenu using JavaScript if regular click fails
            try {
                WebElement s = wait.until(ExpectedConditions.elementToBeClickable(sub(parent, child)));
                System.out.println("Found submenu element: " + s.getText());
                s.click();
            } catch (Exception e) {
                System.out.println("Regular click failed, trying JavaScript click");
                WebElement s = wait.until(ExpectedConditions.presenceOfElementLocated(sub(parent, child)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", s);
            }
            
            // Wait for any animations to complete
            Thread.sleep(1000);
            return this;
        } catch (Exception e) {
            System.out.println("Error clicking submenu: " + e.getMessage());
            throw e;
        }
    }

    public MenuNavigation waitForPageLoad() {
        wait.until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        return this;
    }

    public void printAllMenus() {
        List<WebElement> menus = driver.findElements(By.xpath("//ul[contains(@class,'categorymenu')]//a"));
        for (WebElement el : menus) {
            System.out.println("Menu: '" + el.getText() + "'");
        }
    }
}