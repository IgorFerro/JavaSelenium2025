package com.automationteststore.pages.menu;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.automationteststore.pages.menu.MenuTargets.*;

public class MenuTasks {
    public static Task navigateToHome() {
        return Task.where("{0} navigates to home page",
            Click.on(HOME)
        );
    }
    
    public static Task navigateToApparel() {
        return Task.where("{0} navigates to apparel section",
            Click.on(APPAREL)
        );
    }
    
    public static Task navigateToMakeup() {
        return Task.where("{0} navigates to makeup section",
            Click.on(MAKEUP)
        );
    }
    
    public static Task navigateToSkincare() {
        return Task.where("{0} navigates to skincare section",
            Click.on(SKINCARE)
        );
    }
    
    public static Task navigateToFragrance() {
        return Task.where("{0} navigates to fragrance section",
            Click.on(FRAGRANCE)
        );
    }
    
    public static Task navigateToMen() {
        return Task.where("{0} navigates to men section",
            Click.on(MEN)
        );
    }
    
    public static Task navigateToHairCare() {
        return Task.where("{0} navigates to hair care section",
            Click.on(HAIR_CARE)
        );
    }
    
    public static Task navigateToBooks() {
        return Task.where("{0} navigates to books section",
            Click.on(BOOKS)
        );
    }
} 