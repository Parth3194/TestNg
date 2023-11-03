package com.testcases.testng;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pom.tng.Logintng;
import com.pom.tng.Registertng;
import com.utilities.tng.Readfile;

public class TestbaseTng {
public WebDriver driver ;
public Readfile config ;
public Logintng lot;
public Registertng rgt;
public  TestbaseTng TB;

public WebDriver browser() throws IOException {
	config = new Readfile();
	String browser = config.getbrowser();
	switch(browser) {
	case "chrome":
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		break;
	case "edge":
		driver = new EdgeDriver();
	case "firefox":
		driver = new FirefoxDriver();
		break;
	}
	return driver;
}


}
