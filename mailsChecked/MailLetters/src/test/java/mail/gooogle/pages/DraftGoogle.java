package mail.gooogle.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractElements.BasePage;

public class DraftGoogle extends BasePage
{

	private final String GO_TO_SEND = "//span/a[@href='https://mail.google.com/mail/#sent' ]";
	private final String CHECK_THEME ="//span[contains(text(),'Theme')]";

	public DraftGoogle(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = GO_TO_SEND)
	private WebElement gotoSendLettersGoogle;

	@FindBy(xpath = CHECK_THEME)
	private WebElement openDraftGoogle;
	
	public SendLetterGoogle openDraftLetter()
	{
		openDraftGoogle.click();
		return new SendLetterGoogle(driver);
	}

	public LogoutGoogle goToSendLetters() 
	{
		gotoSendLettersGoogle.click();
		return new LogoutGoogle(driver);
	}

}
