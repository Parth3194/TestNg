package com.utilities.tng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.testcases.testng.TestbaseTng;

public class Readfile extends TestbaseTng {
Properties pro = new Properties ();
public Readfile() throws IOException {
	FileInputStream ip = new FileInputStream("C:\\Users\\parth\\eclipse-workspace\\TestNGFramework\\src\\test\\java\\com\\utilities\\tng\\Configuration");
    pro.load(ip);
}

public String getbrowser() {
	String browser = pro.getProperty("browser");
	return browser;
}
}
