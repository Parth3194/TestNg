package com.pom.tng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testcases.testng.TestbaseTng;

public class Registertng extends TestbaseTng {
WebDriver driver;

public Registertng(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath= "//a[@href='#']//p[contains(text(),'Customers')]")
WebElement Customerslink;

@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
WebElement Customer;

@FindBy(xpath="//a[@class='btn btn-primary']")
WebElement Addnewbutton;

@FindBy(id="Email")
WebElement Emailtextbox;

@FindBy(id="Password")
WebElement passwordtextbox;

@FindBy(id="FirstName")
WebElement Firstnametextbox;

@FindBy(id="LastName")
WebElement Lastnametextbox;

@FindBy(id="Gender_Male")
WebElement GenderradioButton;

@FindBy(id="Company")
WebElement CompanyTextbox;

@FindBy(id="IsTaxExempt")
WebElement Checkbox;

@FindBy(id="AdminComment")
WebElement Admintextbox;

@FindBy(xpath="//button[@name='save' and @type='submit']")
WebElement Savebutton;

@FindBy(id="DateOfBirth")
WebElement DOB;
@ FindBy(xpath="//button[text()='Log in']")
private WebElement loginbutton;

public void Newsletterselection() {
    WebElement Newsletter = driver.findElement(By.xpath("//div[@role='listbox']"));
	Newsletter.click();
	WebElement select = driver.findElement(By.xpath("//li[text()='Test store 2']"));
	select.click();
	}
public void Managevendor() {
	WebElement drp = driver.findElement(By.xpath("//select[@id='VendorId']"));
	Select s = new Select (drp);
	s.selectByVisibleText("Vendor 1");
	}


public void addcustomer() {
	loginbutton.click();
	Customerslink.click();
	Customer.click();
	Addnewbutton.click();
}

public void entercustomerdata(String email, String password, String firstname, String lastname, String dob, String companyname, String admincomment) {
	Emailtextbox.sendKeys(email);
	passwordtextbox.sendKeys(password);
	Firstnametextbox.sendKeys(firstname);
	Lastnametextbox.sendKeys(lastname);
	GenderradioButton.click();
	DOB.sendKeys(dob);
	CompanyTextbox.sendKeys(companyname);
	Checkbox.click();
	Admintextbox.sendKeys(admincomment);
}

public void save(){
	Savebutton.click();
}
}
