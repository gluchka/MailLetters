package mail.gooogle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class PersAccountGoogle extends BasePage
{


	public PersAccountGoogle(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private final String NEW_LETTER_BUTTON ="//div[@class='z0']/div"; 
	private final String GOTO_DRAFTS ="//a[contains(@href, '#drafts')]";  
	
	@FindBy(xpath = NEW_LETTER_BUTTON)
	private WebElement writeLetterButtonGoogle;
		
	@FindBy(xpath = GOTO_DRAFTS)
	private WebElement gotoDraftButtonGoogle;
	
	public WriteLetterGoogle writeLetterClick(WebDriver driver)
	{
		writeLetterButtonGoogle.click();
		return new WriteLetterGoogle(driver);
	}
		
	public DraftGoogle goToDraftsClick(WebDriver driver)
	{
		gotoDraftButtonGoogle.click();
		return new DraftGoogle(driver);
	}
	
}
