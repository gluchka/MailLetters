package mail.gooogle.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class LoginGoogle extends BasePage 
{

	private final String  LOGIN_GOOGLE = "//input[@id='Email']"; 
	private final String  LOGIN_GOOGLE_BUTTON = "//input[@id='next']"; 
	private final String  PASSWORD_GOOGLE = "//input[@id='Passwd']";  
	private final String  PASS_BUTTON_GOOGLE ="//input[@id='signIn']"; 
	
	
	public LoginGoogle(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = LOGIN_GOOGLE)
	private WebElement loginGoogleTextField;
	
	@FindBy(xpath = LOGIN_GOOGLE_BUTTON)
	private WebElement loginButtonGoogle;

	@FindBy(xpath = PASSWORD_GOOGLE)
	private WebElement passGoogleTextField;
	
	@FindBy(xpath = PASS_BUTTON_GOOGLE)
	private WebElement passButtonGoogle;
	
	public LoginGoogle enterLogin(String login)
	{
		loginGoogleTextField.sendKeys(login);
		return this;
	}

	public LoginGoogle clickLoginButton(WebDriver driver)
	{
		loginButtonGoogle.click();
		return this;
	}
	
	public LoginGoogle enterPassword(String password)
	{
		passGoogleTextField.sendKeys(password);
		return this;
	}
	
	public PersAccountGoogle clickSignInButton(WebDriver driver)
	{
		passButtonGoogle.click();
		return new PersAccountGoogle(driver);
	}

}
