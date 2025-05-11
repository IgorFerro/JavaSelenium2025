package com.automationteststore.pages.menu;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectMenuScreenplay {
    // Targets (locators)
    public static final Target MEN_MENU = Target.the("Men menu")
        .locatedBy("(//a[contains(text(),'Men')])[3]");
    
    public static final Target SKINCARE_SUBMENU = Target.the("Skincare submenu")
        .locatedBy("(//a[contains(text(),'Skincare')])[3]");
    
    public static final Target CART_LINK = Target.the("Cart link")
        .locatedBy("(//a[contains(@href, 'checkout/cart')])[2]");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button")
        .locatedBy("//div[@id='maincontainer']/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a/i");

    // Tasks
    public static Task navigateToMenSkincare() {
        return Task.where("{0} navigates to Men's Skincare section",
            Click.on(MEN_MENU),
            Click.on(SKINCARE_SUBMENU)
        );
    }

    public static Task addProductsToCart() {
        return Task.where("{0} adds products to cart",
            Click.on(ADD_TO_CART_BUTTON)
        );
    }

    public static Task goToCart() {
        return Task.where("{0} goes to cart",
            Click.on(CART_LINK)
        );
    }
} 