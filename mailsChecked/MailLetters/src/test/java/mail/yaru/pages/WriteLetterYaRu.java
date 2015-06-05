package mail.yaru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class WriteLetterYaRu extends BasePage{

	private final String TO_RECIPIENT =".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div/input"; 
	private final String LETTER_SUBJECT =".//*[@id='compose-subj']"; 
	private final String LETTER_CONTENT ="//*[@id='compose-send']"; 
	private final String CLICK_CANCEL_ADD_DRAFT =".//*[@href='#draft']"; 
	private final String CLICK_ADD_TO_DRAFT ="//html[@id='js']/body/div[6]//button"; 
	
	public WriteLetterYaRu(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = TO_RECIPIENT)
	private WebElement enterRecipientField;
	
	@FindBy(xpath = LETTER_SUBJECT)
	private WebElement enterSubjectField;

	@FindBy(xpath = LETTER_CONTENT)
	private WebElement enterContentField;
	
	@FindBy(xpath =CLICK_CANCEL_ADD_DRAFT)
	private WebElement clickCancelButton;
	
	@FindBy(xpath = CLICK_ADD_TO_DRAFT)    
	private WebElement saveToDraftButton;
	
	public WriteLetterYaRu enterRecipient(String recipient){
		enterRecipientField.sendKeys(recipient);
		return this;
	}
	
	public WriteLetterYaRu enterSubject(String subject){
		enterSubjectField.sendKeys(subject);
		return this;
	}
	
	public WriteLetterYaRu enterContent(String content){
		enterContentField.sendKeys(content);
		return this;
	}
	
	public WriteLetterYaRu clickCancelButton(){
		clickCancelButton.click();
		return this;
	}
	
	public DraftYaRu saveToDruftButton(WebDriver driver){
		saveToDraftButton.click();
		return new DraftYaRu(driver);
	}
	
}
