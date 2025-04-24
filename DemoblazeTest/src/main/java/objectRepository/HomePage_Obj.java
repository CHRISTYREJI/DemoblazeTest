package objectRepository;

import org.openqa.selenium.By;

public class HomePage_Obj {
        //Sign up locators
	public By SignIn(){return By.xpath("//a[@id='signin2']");}
	public By SignInPopup(){return By.xpath("//h5[@id='signInModalLabel']");}
	public By UserName(){return By.xpath("//input[@id='sign-username']");}
	public By password(){return By.xpath("//input[@id='sign-password']");}
	public By SignUp(){return By.xpath("//button[text()='Sign up']");}
	//userlogin locators
	public By UserLogin(){return By.xpath("//a[@id='login2']");}
	public By LoginInPopup(){return By.xpath("//h5[@id='logInModalLabel']");}
	public By LoginUsername(){return By.xpath("//input[@id='loginusername']");}
	public By LoginPassword(){return By.xpath("//input[@id='loginpassword']");}
	public By BtnLogin(){return By.xpath("//button[text()='Log in']");}
	public By Success(String username) {return By.xpath("//a[contains(text(),'"+username+"')]");}	
	//addToCart locators
	public By ProductSelect(){return By.xpath("//a[text()='Samsung galaxy s6']/parent::h4");}
	public By CartPage(){return By.xpath("//h2[text()='Samsung galaxy s6']");}
	public By BtnaddToCart(){return By.xpath("//a[text()='Add to cart']");}
	//cart page locators
	public By BtnCart(){return By.xpath("//a[@id='cartur']");}
	public By CartProductList(){return By.xpath("//td[text()='Samsung galaxy s6']");}
	public By PlaceOrder(){return By.xpath("//button[text()='Place Order']");}
	//place order page locators
	public By NameField(){return By.xpath("//input[@id ='name']");}
	public By CountryField(){return By.xpath("//input[@id ='country']");}
	public By CityField(){return By.xpath("//input[@id ='city']");}
	
	
}
