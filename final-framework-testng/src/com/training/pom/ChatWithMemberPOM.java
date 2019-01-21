package com.training.pom;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatWithMemberPOM {
private WebDriver driver; 
	
	public ChatWithMemberPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	 		
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//A[@href='main/auth/courses.php']")
    private WebElement courses;
	
	@FindBy(name="search_term")
    private WebElement searchCourse;
	
	@FindBy(xpath="//BUTTON[@class='btn btn-default']")
	private WebElement searchBtn;

	@FindBy(xpath="//A[@title='SELENIUM PROJECT'][text()='SELENIUM PROJECT']")
	private WebElement courseLink;

	@FindBy(linkText="Groups")
	private WebElement groups;
	
	@FindBy(linkText="Group 0001")
	private WebElement grouplink;

	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[3]/ul/li[8]/a/img")
	private WebElement chats;

	@FindBy(xpath="//*[@id=\"chat-users\"]/li[3]/div/ul/li[1]/button/i")
	private WebElement chatMsg;
	
	@FindBy(xpath="//*[@id=\"tab1\"]/div/div[1]/div")
	private WebElement message;

	@FindBy(id="chat-send-message")
	private WebElement sendBtn;

	
	public void sendUserName(String string) {
		this.userName.clear();
		this.userName.sendKeys(string);
		
	}

	public void sendPassword(String string) {
		this.password.clear(); 
		this.password.sendKeys(string); 
		
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}
	
	public void clickOnCourses() {
		this.courses.click();
		
	}

	public void sendSearchCourse(String string) {
		this.searchCourse.clear();
		this.searchCourse.sendKeys(string);
		
	}
	
	public void clickSearchBtn() {
	 	this.searchBtn.click();
		
	}

	public void clickCourseLink() {
		this.courseLink.click();
		
	}

	public void clickOnGroups() {
		this.groups.click();
		
	}

	public void clickAssignedGroup() {
		this.grouplink.click();
		
	}

	public void clickChatImg() {
		this.chats.click();
		
	}

	public void clickMemberToChat() throws InterruptedException {
		Set<String> allwindow = driver.getWindowHandles();
		 
		for(String eachwindow:allwindow)
        {
       driver.switchTo().window(eachwindow);
      	}
		
		Thread.sleep(5000);
		this.chatMsg.click();
		this.message.clear();
		this.message.sendKeys("Hello");
		
		this.sendBtn.click();
	 
	}

	 
}
