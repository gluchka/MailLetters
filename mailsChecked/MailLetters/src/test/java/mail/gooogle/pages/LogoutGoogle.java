package mail.gooogle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class LogoutGoogle extends BasePage
{

public LogoutGoogle(WebDriver driver) 
{
		super(driver);
		PageFactory.initElements(driver, this);
	}

private final String CLICK_TO_LOGOUT = "//div//div[@img-loaded='1']";
private final String LOGOUT = "//div/a[@href='https://mail.google.com/mail/logout?hl=ru']";

	@FindBy(xpath = CLICK_TO_LOGOUT)
	private WebElement clicToLogoutGoogle;
	
	@FindBy(xpath = LOGOUT)
	private WebElement logoutYaRu;
	
	public LogoutGoogle clickLogoutFromGoogle()
	{
		clicToLogoutGoogle.click();
		return this;
	}

	public void logoutGoogle()
	{
		logoutYaRu.click();
	
	}
	
}
