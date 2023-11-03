package com.pom.tng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.testng.TestbaseTng;

public class Logintng extends TestbaseTng{

	WebDriver driver;

public Logintng(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Logout")
private WebElement logout;

@FindBy(id="Email")
private WebElement usernametextbox;

@FindBy(id="Password")
private WebElement passwordtextbox;

@ FindBy(xpath="//button[text()='Log in']")
private WebElement loginbutton;

public void performlogin(String username, String password) {
usernametextbox.clear();
usernametextbox.sendKeys(username);
passwordtextbox.clear();
passwordtextbox.sendKeys(password);
loginbutton.click();
	}

public void logout() {
	logout.click();
}
	
}
