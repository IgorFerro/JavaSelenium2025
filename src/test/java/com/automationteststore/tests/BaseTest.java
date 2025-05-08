package com.automationteststore.tests;

import com.automationteststore.utils.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        try {
            driver = DriverManager.getDriver();
            driver.get("https://automationteststore.com/");
        } catch (Exception e) {
            if (driver != null) {
                driver.quit();
            }
            throw new RuntimeException("Failed to setup test: " + testInfo.getDisplayName(), e);
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            DriverManager.quitDriver();
        } catch (Exception e) {
            System.err.println("Error during driver cleanup: " + e.getMessage());
        }
    }
} 