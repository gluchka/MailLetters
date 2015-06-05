import static org.testng.Assert.assertTrue;
import mail.yaru.yaruHelper.StepsYaRu;
import org.testng.annotations.Test;

import abstractElements.DriverManager;

public class AllYaRuTest 
{

	private final String MAIL_URL = "http://mail.yandex.ua";
	private final String LOGIN = "userYRtest";
	private final String PASSWORD = "useruserYR";
	private final String RECIPIENT = "userYRtest@yandex.ru";
	private final String THEME = "Theme";
	private final String TEXT = "TEXT";
	
	
	StepsYaRu yaruMail;

	@Test
	public void verifyYandexLogin() 
	{
		yaruMail = new StepsYaRu(LOGIN,PASSWORD ,RECIPIENT,THEME, TEXT);
		
		yaruMail.loginToEmail(DriverManager.chooseFirefoxDriver(),MAIL_URL);
		assertTrue(yaruMail.loginCorrect());
		
	}
	
	@Test
	public void yandexSendLetter() 
	{	
		yaruMail.choosewriteLetter();
		yaruMail.writeLetter();
		yaruMail.openDraftLetter();
		yaruMail.sendLetter();
	}

	 @Test
	 public void verifyYandexLogout()
	 {
		 yaruMail.checkThatLetterSend();
		 yaruMail.logout();
	 }

}
