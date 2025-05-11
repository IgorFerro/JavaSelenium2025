package com.automationteststore.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.automationteststore.pages.menu.SelectMenuScreenplay.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class SelectMenuScreenplayTst {
    
    private WebDriver driver;
    private static final String BASE_URL = "https://automationteststore.com/";
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }
    
    @Test
    public void testCompleteShoppingFlow() {
        Actor user = Actor.named("UserAddOneItemToCart")
            .whoCan(BrowseTheWeb.with(driver));
            
        user.attemptsTo(
            Open.url(BASE_URL),
            navigateToMenSkincare(),
            addProductsToCart(),
            goToCart()
        );
        
        user.attemptsTo(
            Ensure.thatTheCurrentPage().currentUrl().contains("checkout/cart")
        );
    }
} 