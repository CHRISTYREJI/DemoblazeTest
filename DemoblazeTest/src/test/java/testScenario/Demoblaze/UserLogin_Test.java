package testScenario.Demoblaze;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
 
import TestData.CommonData;
import testCases.UserLogin;
import utilPack.DriverInitialization;


public class UserLogin_Test extends DriverInitialization{
	@Test()
	public void TC01_DemoblaseTest() {
		
		UserLogin userlogin= new UserLogin(driver);
		userlogin.TC01_Demoblaze();
}
}
