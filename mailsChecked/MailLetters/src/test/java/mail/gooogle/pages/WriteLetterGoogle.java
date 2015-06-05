package mail.gooogle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class WriteLetterGoogle extends BasePage
{

	private final String TO_RECIPIENT ="//textarea[@name='to']"; 
	private final String LETTER_SUBJECT ="//input[@name='subjectbox']"; 
	private final String LETTER_CONTENT ="//div[@role='textbox']"; 
	private final String CLICK_CANCEL_ADD_DRAFT =".//img[3]"; 
	private final String GO_TO_DRAFT ="//a[contains(@href, '#drafts')]"; 
	
	public WriteLetterGoogle(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = TO_RECIPIENT)
	private WebElement enterRecipientField;
	
	@FindBy(xpath = LETTER_SUBJECT)
	private WebElement enterSubjectField;

	@FindBy(xpath = LETTER_CONTENT)
	private WebElement enter—ontentField;
	
	@FindBy(xpath =CLICK_CANCEL_ADD_DRAFT)
	private WebElement clickCancelButton;
	
	@FindBy(xpath = GO_TO_DRAFT)    
	private WebElement goToDraftButton;
	
	public WriteLetterGoogle enterRecipient(String recipient)
	{
		enterRecipientField.sendKeys(recipient);
		return this;
	}
	
	public WriteLetterGoogle enterSubject(String subject)
	{
		enterSubjectField.sendKeys(subject);
		return this;
	}
	
	public WriteLetterGoogle enter—ontent(String content)
	{
		enter—ontentField.sendKeys(content);
		return this;
	}
	
	public DraftGoogle saveToDruftButton(WebDriver driver)
	{
		clickCancelButton.click();
		goToDraftButton.click();
		return new DraftGoogle(driver);
	}
	
}
