package com.automationteststore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "loginFrm_loginname")
    private WebElement usernameInput;

    @FindBy(id = "loginFrm_password")
    private WebElement passwordInput;

    @FindBy(css = "button[title='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
} 