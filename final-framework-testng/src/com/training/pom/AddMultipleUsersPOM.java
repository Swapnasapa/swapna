package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddMultipleUsersPOM {
private WebDriver driver; 
	
	public AddMultipleUsersPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="(//*[@class='img-circle'])[1]")
	private WebElement logoutBtn; 
	
	@FindBy(xpath="//*[@id='logout_button']")
	private WebElement clickBtn;

	@FindBy(id="firstname")
	private WebElement firstName;

	@FindBy(id="lastname")
	private WebElement lastName; 
	
	@FindBy(id="email")
	private WebElement email;

	@FindBy(id="username")
	private WebElement loginName;

	@FindBy(id="password")
	private WebElement userPassword;

	@FindBy(name="submit")
	private WebElement addUser;

	@FindBy(name="password[password_auto]")
	private WebElement enterPassword;

	@FindBy(linkText="Add a user")
	private WebElement addUsersLink;

	@FindBy(linkText="Administration")
	private WebElement clickAdmin; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickLogout() {
		this.logoutBtn.click();
		this.clickBtn.click();
		
		
	}
	

	public void clickAddUserBtn() {
		this.addUsersLink.click();
		
	}


	public void sendFirstname(String firstname) {
		this.firstName.clear();
		this.firstName.sendKeys(firstname);
		
	}

	public void sendLastname(String lastname) {
		this.lastName.clear();
		this.lastName.sendKeys(lastname);
		
	}

	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		
	}

	public void sendLoginName(String login) {
		this.loginName.clear();
		this.loginName.sendKeys(login);
		
	}
	
	public void selectPasswordButton() {
		this.enterPassword.click();
		
	}

	public void sendUserPassword(String password2) {
		this.userPassword.clear();
		this.userPassword.sendKeys(password2);
		
	}

	public void clickAddBtn() {
		this.addUser.click();
		
	}

	public void clickAdminBtn() {
		this.clickAdmin.click();
		
	}

	

	 
}
                                       
