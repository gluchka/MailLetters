package mail.yaru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.BasePage;

public class DraftYaRu extends BasePage {

	private final String GO_TO_SEND = "//a[contains(text(),'Отправленные')]";

	public DraftYaRu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = GO_TO_SEND)
	private WebElement gotoSendLettersYaRu;

	public SendLetterYaRu openDraftLetter(String topic) {
		driver.findElement(By.xpath("//span[@title='" + topic + "']")).click();
		return new SendLetterYaRu(driver);
	}

	public LogoutYaRu goToSendLetters(){
		gotoSendLettersYaRu.click();
		return new LogoutYaRu(driver);
	}	
}
