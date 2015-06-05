
import mail.gooogle.googleHelper.StepsGoogle;
import org.testng.annotations.Test;
import abstractElements.DriverManager;

public class AllGoogleTest {

	private final String MAIL_URL = "https://accounts.google.com/ServiceLogin?service=mail";
	private final String LOGIN = "userYRtest";
	private final String PASSWORD = "useruser123";
	private final String RECIPIENT = "userYRtest@gmail.com";
	private final String THEME = "Theme";
	private final String TEXT = "TEXT";
	
	StepsGoogle googleMail;

	@Test(description = "login to email")
	public void verifyGoogleLogin()
	{
		googleMail = new StepsGoogle(LOGIN, PASSWORD, RECIPIENT, THEME, TEXT);
		googleMail.loginToEmail(DriverManager.chooseFirefoxDriver(), MAIL_URL);
	}

	
	@Test(dependsOnMethods = { "GoogleTestLogin" }, description = "send letter")
	public void googleSendLetter()
	{
		googleMail.choosewriteLetter();
		googleMail.writeLetter("gluchka@ukr.net");
		googleMail.openDraftLetter();
		googleMail.sendLetter();
		googleMail.checkThatLetterSend();
	}

	@Test(dependsOnMethods = { "mainGoogleFunctional" }, description = " logout")
	public void verifyGoogleLogout()
	{
		googleMail.logout();
	}

}
