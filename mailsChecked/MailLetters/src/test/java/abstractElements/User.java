package abstractElements;

public abstract class User 
{

	private String login;
	private String password;
	private String recipient;
	private String subject;
	private String content;

	public User(){}
	
	public User(String login, String password, String recipient,
			String theme, String content)
	{
		setLogin(login);
		setPassword(password);
		setRecipient(recipient);
		setTheme(theme);
		setContent(content);
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login= login;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getRecipient() 
	{
		return recipient;
	}

	public void setRecipient(String login)
	{
		if (login.contains("@"))
			this.login = login;
		else
			throw new IllegalArgumentException("Error!!! Incorrect recipient");
	}

	public String getTheme() 
	{
		return subject;
	}

	public void setTheme(String theme) 
	{
		this.subject = theme;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}
}
