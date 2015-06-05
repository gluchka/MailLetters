package mail.yaru.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class LoginYaRu extends BasePage {

	private final String  LOGIN_YARU = "//input[@name='login']"; 
	private final String  PASSWORD_YARU = "//input[@name='passwd']";  
	private final String  LOGIN_BUTTON_YARU ="//button[@type='submit']"; 
			
	public LoginYaRu(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = LOGIN_YARU)
	private WebElement loginYaRuTextField;

	@FindBy(xpath = PASSWORD_YARU)
	private WebElement passYaRuTextField;
	
	@FindBy(xpath = LOGIN_BUTTON_YARU)
	private WebElement loginButtonYaRu;
	
	public LoginYaRu enterLogin(String login){
		loginYaRuTextField.sendKeys(login);
		return this;
	}


	public LoginYaRu enterPassword(String password){
		passYaRuTextField.sendKeys(password);
		return this;
	}
	
	public PersAccountYaRu clickSignInButton(WebDriver driver){
		loginButtonYaRu.click();
		return new PersAccountYaRu(driver);
	}
	
}
