package com.automationteststore.pages.menu;

import net.serenitybdd.screenplay.targets.Target;

public class MenuTargets {
    public static final Target HOME = Target.the("Home menu")
        .locatedBy("//a[contains(text(),'Home')]");
    
    public static final Target APPAREL = Target.the("Apparel menu")
        .locatedBy("(//a[contains(text(),'Apparel & accessories')])[2]");
    
    public static final Target MAKEUP = Target.the("Makeup menu")
        .locatedBy("(//a[contains(text(),'Makeup')])[2]");
    
    public static final Target SKINCARE = Target.the("Skincare menu")
        .locatedBy("(//a[contains(text(),'Skincare')])[2]");
    
    public static final Target FRAGRANCE = Target.the("Fragrance menu")
        .locatedBy("(//a[contains(text(),'Fragrance')])[2]");
    
    public static final Target MEN = Target.the("Men menu")
        .locatedBy("(//a[contains(text(),'Men')])[3]");
    
    public static final Target HAIR_CARE = Target.the("Hair Care menu")
        .locatedBy("(//a[contains(text(),'Hair Care')])[2]");
    
    public static final Target BOOKS = Target.the("Books menu")
        .locatedBy("(//a[contains(text(),'Books')])[2]");
} 