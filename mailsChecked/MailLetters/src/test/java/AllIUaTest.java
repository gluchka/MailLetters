
import mail.iua.pages.LoginPage;
import mail.iua.pages.MailPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import abstractElements.DriverManager;

public class AllIUaTest {
		
	private final String MAIL_URL ="http://i.ua/";
	private final String LOGIN = "useriua";
	private final String PASSWORD = "userpassword123";
	private final String RECIPIENT = "gluchka@ukr.net";
	private final String THEME = "Theme";
	private final String TEXT = "TEXT";
	
		private WebDriver driver;
		protected LoginPage loginPage;
		protected MailPage iuaMail;

		@Test(description=" login to email")
		public void verifyIUILogin()
		{
			driver = DriverManager.chooseFirefoxDriver();
			driver.get(MAIL_URL);
			loginPage = new LoginPage(driver);
			
			iuaMail = loginPage.typeUserName(LOGIN).typePassword(PASSWORD).clickLoginButton();
			iuaMail.waitForEmailTitle();		
		}
		
		@Test(dependsOnMethods={ "IUaTestLogin" },description=" mainFunctional")
		public void iuiSendLetter() 
		{
			
			iuaMail.clickButtonWriteAMail();
			
			iuaMail.fillSendToTextField(RECIPIENT).fillSubjectTextField(THEME).fillMailBodyTextField(TEXT).clickButtonSaveInDrafts();
			
			iuaMail.clickOnLinkDraftsFolder().verifyThatMailIsPresentInInbox(THEME);
			iuaMail.clickOnLetter(THEME).compareDraftWithPreviousMail(TEXT);
			iuaMail.clickOnSubmitButton();
			
			iuaMail.clickOnSentMailFolder().verifyThatMailIsPresentInInbox(THEME);			
		}

		 @Test(dependsOnMethods={ "mainIUafunction" },description=" logout")
		 public void verifyIUILogout()
		 { 
			 iuaMail.clickButtonSettings().clickButtonExitMail();	
			 driver.quit();
		 }

}
