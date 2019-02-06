package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StudentEditPasswordPOM {
private WebDriver driver; 
	
	public StudentEditPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//A[@href='http://elearning.upskills.in/main/auth/profile.php']")
 	private WebElement editProf; 
	
	@FindBy(name="password0")
	private WebElement password0;
	
	@FindBy(name="password1")
	private WebElement password1;
	
	@FindBy(name="password2")
	private WebElement password2;
	
	@FindBy(id="profile_apply_change")
	private WebElement profChange; 
	
  		
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

	public void clickEditProfile() {
		this.editProf.click(); 
		
	}
	
	public void sendOldPassword(String password) {
		this.password0.clear(); 
		this.password0.sendKeys(password); 
	}
	
	public void sendNewPassword(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void sendConfPassword(String password) {
		this.password2.clear(); 
		this.password2.sendKeys(password); 
	}
	 
	 
	public void clickSaveBtn() {
		this.profChange.click(); 
	}

 
}
