package mail.gooogle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class SendLetterGoogle  extends BasePage
{

	public SendLetterGoogle(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//private final String  CLICK_TO_SEND = "//a[contains(@href, 'https://mail.google.com/mail/?pli=1#sent')]";   
	private final String  CLICK_TO_SEND = "//tbody//div[count(div) = 2]/div[@role='button' and @data-tooltip]";
	
	@FindBy(id = CLICK_TO_SEND)
	private WebElement sendLetterClick;
	
	public PersAccountGoogle clickSendLetterButton(WebDriver driver)
	{
		sendLetterClick.click();
		return new PersAccountGoogle(driver);
	}	
	

}
