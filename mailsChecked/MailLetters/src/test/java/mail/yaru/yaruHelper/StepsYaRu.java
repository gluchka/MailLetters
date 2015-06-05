package mail.yaru.yaruHelper;

import java.util.concurrent.TimeUnit;

import mail.yaru.pages.DraftYaRu;
import mail.yaru.pages.LoginYaRu;
import mail.yaru.pages.LogoutYaRu;
import mail.yaru.pages.PersAccountYaRu;
import mail.yaru.pages.SendLetterYaRu;
import mail.yaru.pages.WriteLetterYaRu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractElements.User;

public class StepsYaRu extends User {

	private LoginYaRu loginYaRu;
	private PersAccountYaRu persAccount;
	private WriteLetterYaRu writeLetter;
	private DraftYaRu draftYaRu;
	private SendLetterYaRu sendLetter;
	private LogoutYaRu logout;

	
	private final String SUBJECT_FIELD = "compose-subj";
	private final String THEME_FIELD = "compose-send";
	private final String DRAFT_EXISTENCE = "//div[@class='b-messages__placeholder-item'][1]";	
	
	
	public StepsYaRu(){}
	
	
	public StepsYaRu(String login, String password, String recipient,
			String theme, String content) {
		super(login, password, recipient, theme, content);
	}

	public PersAccountYaRu loginToEmail(WebDriver driver, String mail) {
		loginYaRu =  (LoginYaRu) new LoginYaRu(driver).open(mail);
		loginYaRu = PageFactory.initElements(loginYaRu.driverTo(),	LoginYaRu.class);
		persAccount = loginYaRu.enterLogin(getLogin()).enterPassword(getPassword()).clickSignInButton(loginYaRu.driverTo());
		return persAccount;
	}

	public boolean loginCorrect() {
		return persAccount.getTitle().contains("Входящие");
	}
	
	public WriteLetterYaRu choosewriteLetter(){
		persAccount = PageFactory.initElements(persAccount.driverTo(),PersAccountYaRu.class);		
		writeLetter=persAccount.writeLetterClick(persAccount.driverTo());
		return writeLetter;
	}
	
	public DraftYaRu writeLetter(){
		writeLetter = PageFactory.initElements(writeLetter.driverTo(),WriteLetterYaRu.class);		
		draftYaRu=writeLetter.enterRecipient(getLogin()).enterSubject(getTheme()).enterContent(getContent()).clickCancelButton().saveToDruftButton(writeLetter.driverTo());
		return draftYaRu;
	}
	
	public SendLetterYaRu openDraftLetter(){
		sendLetter= draftYaRu.openDraftLetter(getTheme());
		return sendLetter;
	}


	public PersAccountYaRu sendLetter() {
			  Assert.assertEquals(getTheme(),sendLetter.driverTo().findElement(By.id(SUBJECT_FIELD)).getAttribute("value"));	
			  Assert. assertEquals(getContent(), sendLetter.driverTo().findElement(By.id(THEME_FIELD)).getAttribute("value"));	
//			  logout.driverTo().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  persAccount= sendLetter.clickSignInButton(sendLetter.driverTo());
			  return persAccount;
	}
	

		public LogoutYaRu checkThatLetterSend() {
	persAccount.goToEnetrClick().goToDraftsClick(persAccount.driverTo());
	logout.driverTo().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Assert.assertEquals(draftYaRu.driverTo().findElement(By.xpath(DRAFT_EXISTENCE)).getText(),"В папке «Черновики» нет писем.");
	logout=draftYaRu.goToSendLetters();
	return logout;
	}	
	
	public void logout(){
		logout.driverTo().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logout.clickLogoutFromYaRu();
		logout.logoutYaRu();
	}
	
}
