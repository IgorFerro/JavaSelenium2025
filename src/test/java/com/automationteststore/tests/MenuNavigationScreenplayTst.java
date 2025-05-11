package com.automationteststore.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.automationteststore.pages.menu.MenuTasks.*;
import static com.automationteststore.pages.menu.MenuTargets.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
public class MenuNavigationScreenplayTst extends BaseTest {
    
    private static final String BASE_URL = "https://automationteststore.com/";
    
    @Test
    public void testMenuNavigation() {
        Actor user = Actor.named("User")
            .whoCan(BrowseTheWeb.with(driver));
            
        user.attemptsTo(
            Open.url(BASE_URL),
            WaitUntil.the(HOME, isVisible()),
            navigateToHome(),
            WaitUntil.the(APPAREL, isVisible()),
            navigateToApparel(),
            WaitUntil.the(MAKEUP, isVisible()),
            navigateToMakeup(),
            WaitUntil.the(SKINCARE, isVisible()),
            navigateToSkincare(),
            WaitUntil.the(FRAGRANCE, isVisible()),
            navigateToFragrance(),
            WaitUntil.the(MEN, isVisible()),
            navigateToMen(),
            WaitUntil.the(HAIR_CARE, isVisible()),
            navigateToHairCare(),
            WaitUntil.the(BOOKS, isVisible()),
            navigateToBooks()
        );
        
        user.attemptsTo(
            Ensure.thatTheCurrentPage().currentUrl().contains("books")
        );
    }
} 