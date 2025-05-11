package com.automationteststore.tests;

import org.junit.jupiter.api.Test;
import com.automationteststore.pages.menu.SelectMenuPageFactory;
import com.automationteststore.tests.BaseTest;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
public class SelectMenuPageFactoryTst extends BaseTest {
    
    @Test
    public void testCompleteShoppingFlow() throws InterruptedException {
        // Initialize the page factory
        SelectMenuPageFactory menuPage = new SelectMenuPageFactory(driver);
        
        // Perform the complete shopping flow
        menuPage.completeShoppingFlow();
        
        // Verify navigation to cart
        assertTrue(driver.getCurrentUrl().contains("checkout/cart"), 
            "Should be redirected to cart page");
    }
} 