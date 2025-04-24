package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.HomePage_Obj ;
import utilPack.GenericPage;



public class UserLogin extends GenericPage {

	GenericPage genPge;
	Assert asrt;

	public UserLogin(WebDriver driver)
	{
		super(driver);
		genPge = new GenericPage(driver);
	}

	public void TC01_Demoblaze()
	{
		UserLogin userlogin= new UserLogin(driver);
		//userlogin.SignUp();
		userlogin.LoginToApplication();	
	}



	//Application-Reusable methods
	public void LoginToApplication()
	{
		HomePage_Obj homepageobj= new HomePage_Obj();

		//Sign Up with user credentials
		genPge.buttonClick(homepageobj.SignIn());
		asrt.assertTrue(genPge.isExists(homepageobj.SignInPopup()), "User is not able to view  sign up popup on clicking sign up button");

		genPge.setData(homepageobj.UserName(), "Christy"+genPge.CreateRandomWithoutNumbers(4));
		String username= genPge.GetValue(homepageobj.UserName());

		genPge.setData(homepageobj.password(), "Reji"+genPge.CreateRandomWithoutNumbers(4));
		String password= genPge.GetValue(homepageobj.password());
		genPge.buttonClick(homepageobj.SignUp());
		Alert alert=driver.switchTo().alert();		
		String AlertText=alert.getText();
		Assert.assertEquals("Sign up successful.", AlertText);
		alert.accept();

		//Login
		genPge.buttonClick(homepageobj.UserLogin());
		asrt.assertTrue(genPge.isExists(homepageobj.LoginInPopup()), "User is not able to view the Login up popup on clicking login button");
		genPge.setData(homepageobj.LoginUsername(), username);
		genPge.setData(homepageobj.LoginPassword(), password);
		genPge.buttonClick(homepageobj.BtnLogin());
		asrt.assertTrue(genPge.isExists(homepageobj.Success(username)), "User is not able to login to the application");
	

		//product selection
		genPge.buttonClick(homepageobj.ProductSelect());
		asrt.assertTrue(genPge.isExists(homepageobj.CartPage()), "User is not able to navigate to cart page after clicking add to cart.");
		genPge.buttonClick(homepageobj.BtnaddToCart());
		Alert alert2=driver.switchTo().alert();		
		String AlertText2=alert2.getText();
		Assert.assertEquals("Product added.", AlertText);
		alert.accept();
		

	}
}
