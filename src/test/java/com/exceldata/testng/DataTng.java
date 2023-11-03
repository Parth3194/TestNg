package com.exceldata.testng;

import org.testng.annotations.DataProvider;

public class DataTng {
	
	@DataProvider(name="login")
	public Object[][] login() {
		Object [][]data = {{"admin@yourstore.com","admin"}};
		return data;
	}
	@DataProvider(name="register")
	public Object [][] register() {
	    Object [][] data = {{"parthchauhan331944@gmail.com","Parth@3194","Parrthsinhh","Chharuhan","31/10/1994","Mycompany","HelloWorld"}};
		return data;
	}

}
