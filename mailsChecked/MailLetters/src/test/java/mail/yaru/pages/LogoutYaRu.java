package mail.yaru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class LogoutYaRu extends BasePage{

public LogoutYaRu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

private final String CLICK_TO_LOGOUT = "//a[@id='nb-1']/span[2]";
private final String LOGOUT = "//div[@id='user-dropdown-popup']//div[11]/a";

	@FindBy(xpath = CLICK_TO_LOGOUT)
	private WebElement clicToLogoutYaRu;
	
	@FindBy(xpath = LOGOUT)
	private WebElement logoutYaRu;
	
	public LogoutYaRu clickLogoutFromYaRu(){
		clicToLogoutYaRu.click();
		return this;
	}
	
	public void logoutYaRu(){
		logoutYaRu.click();
	}
	
}
