package com.automationteststore.tests;

import org.junit.jupiter.api.Test;
import com.automationteststore.pages.menu.SelectMenuPageObjects;
import com.automationteststore.tests.BaseTest;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
public class SelectMenuPageObjectsTst extends BaseTest {
    
    @Test
    public void testCompleteShoppingFlow() throws InterruptedException {
        // Initialize the page object
        SelectMenuPageObjects menuPage = new SelectMenuPageObjects(driver);
        
        // Perform the complete shopping flow
        menuPage.completeShoppingFlow();
        
        // Verify navigation to cart
        assertTrue(driver.getCurrentUrl().contains("checkout/cart"), 
            "Should be redirected to cart page");
    }
}
