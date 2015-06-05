package mail.iua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	public WebElement userLoginTextField;

	@FindBy(how = How.XPATH, using = "//input[@name='pass']")
	public WebElement passwordTextField;

	@FindBy(how = How.XPATH, using = "//div//form//p/input[@type='submit']")
	public WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public LoginPage typeUserName(String userName) 
	{
		userLoginTextField.sendKeys(userName);
		return this;
	}

	public LoginPage typePassword(String password) 
	{
		passwordTextField.sendKeys(password);
		return this;
	}

	public MailPage clickLoginButton()
	{
		loginButton.click();
		return new MailPage(driver);
	}

}
