package com.automationteststore.tests.menuFluent;

import org.junit.jupiter.api.Test;
import com.automationteststore.fluent.*;
import com.automationteststore.tests.BaseTest;

public class SelectMenuFluentTst extends BaseTest {
    @Test
    public void selectMenSkincare() throws InterruptedException {
        MenuNavigation menu = new MenuNavigation(driver);
        
        // Navigate to the website first (assuming you have this setup)
        driver.get("https://automationteststore.com/");
        
        // Click on Men menu and then Skincare submenu
        menu.clickMain("Men")
            .clickSub("Men", "Skincare");
        
        // Add assertions here to verify you're on the correct page
        // For example:
        // assertTrue(driver.getCurrentUrl().contains("skincare"));
    }
}