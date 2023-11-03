package com.testcases.testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exceldata.testng.DataTng;
import com.exceldata.testng.ExcelData;
import com.pom.tng.Logintng;
import com.pom.tng.Registertng;
import com.utilities.tng.Readfile;

public class Register extends TestbaseTng{
	
@BeforeMethod
public void borwsersetup() throws IOException {
	config = new Readfile();
	String browser = config.getbrowser();
	switch(browser) {
	case "chrome" :
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		break;
		
	case "edge" :
		driver = new EdgeDriver();
		break;
	case "firefox" :
		break;
	}
	
}

@Test(priority=1, dataProvider = "register", dataProviderClass=DataTng.class)
public void Addcustomer(String email, String password, String firstname, String lastname, String dob, String companyname, String admincomment) {
	rgt = new Registertng(driver);
	rgt.addcustomer();
	rgt.entercustomerdata(email,password,firstname,lastname,dob,companyname,admincomment);
	rgt.Newsletterselection();
	rgt.Managevendor();
	rgt.save();
}

@AfterMethod
public void teardown() {
	driver.quit();
}
}
