package com.automationteststore.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--window-size=1600,900");
            options.addArguments("--remote-allow-origins=*");
            // options.addArguments("--headless=new");
            // Add these options to handle common issues
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            // Uncomment the following line if you want to run tests in headless mode
            // options.addArguments("--headless");
            
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
} 