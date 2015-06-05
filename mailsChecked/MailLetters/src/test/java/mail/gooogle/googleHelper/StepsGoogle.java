package mail.gooogle.googleHelper;

import java.util.concurrent.TimeUnit;

import mail.gooogle.pages.DraftGoogle;
import mail.gooogle.pages.LoginGoogle;
import mail.gooogle.pages.LogoutGoogle;
import mail.gooogle.pages.PersAccountGoogle;
import mail.gooogle.pages.SendLetterGoogle;
import mail.gooogle.pages.WriteLetterGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractElements.User;

public class StepsGoogle extends User {

	private LoginGoogle loginGoogle;
	private PersAccountGoogle persAccount;
	private WriteLetterGoogle writeLetter;
	private DraftGoogle draftGoogle;
	private SendLetterGoogle sendLetter;
	private LogoutGoogle logout;

	
	private final String SUBJECT_FIELD = "//input[@name='subjectbox']";
	private final String THEME_FIELD = "//div[@role='textbox']";
	private final String DRAFT_EXISTENCE = "//tbody/tr/td[@colspan='3']";	
	
	
	public StepsGoogle() 
	{
	}

	public StepsGoogle(String login, String password, String recipient,String theme, String content) 
	{
		super(login, password, recipient, theme, content);
	}

	public PersAccountGoogle loginToEmail(WebDriver driver, String mail) 
	{
		loginGoogle = (LoginGoogle) new LoginGoogle(driver).open(mail);
		loginGoogle = PageFactory.initElements(loginGoogle.driverTo(),LoginGoogle.class);
		persAccount = loginGoogle.enterLogin(getLogin())
				.clickLoginButton(loginGoogle.driverTo())
				.enterPassword(getPassword())
				.clickSignInButton(loginGoogle.driverTo());
		persAccount.driverTo().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return persAccount;
	}

	public WriteLetterGoogle choosewriteLetter() {
		persAccount = PageFactory.initElements(persAccount.driverTo(),PersAccountGoogle.class);
		writeLetter = persAccount.writeLetterClick(persAccount.driverTo());
		return writeLetter;
	}

	public DraftGoogle writeLetter(String sendTo) 
	{
		writeLetter = PageFactory.initElements(writeLetter.driverTo(),WriteLetterGoogle.class);
		draftGoogle = writeLetter.enterRecipient(sendTo)
				.enterSubject(getTheme()).enterСontent(getContent())
				.saveToDruftButton(writeLetter.driverTo());
		return draftGoogle;
	}

	public SendLetterGoogle openDraftLetter()
	{
		sendLetter = draftGoogle.openDraftLetter();
		return sendLetter;
	}

	public void sendLetter()
	{
		Assert.assertEquals("Theme",sendLetter.driverTo().findElement(By.xpath(SUBJECT_FIELD)).getAttribute("value"));
		Assert.assertEquals("TEXT",sendLetter.driverTo().findElement(By.xpath(THEME_FIELD)).getAttribute("value"));
		sendLetter.clickSendLetterButton(sendLetter.driverTo());
	}

	public LogoutGoogle checkThatLetterSend() 
	{
		persAccount.goToDraftsClick(persAccount.driverTo());
		Assert.assertEquals(draftGoogle.driverTo().findElement(By.xpath(DRAFT_EXISTENCE)).getText(), "Нет сохраненных черновиков.");
		logout = draftGoogle.goToSendLetters();
		return logout;
	}

	public void logout() 
	{
		logout.driverTo().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logout.clickLogoutFromGoogle();
		logout.logoutGoogle();
	}

}
