package com.training.pom;

 
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TeacherPasswordResetPOM {
	
private WebDriver driver; 
private String usePassword;
	
	public TeacherPasswordResetPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	 	}
	
	@FindBy(xpath="//A[@href='http://elearning.hommelle.com/main/auth/lostPassword.php'][text()=' I lost my password ']")
    private WebElement lostPassword;
	
	
	@FindBy(name="user")
    private WebElement userName;
	
	@FindBy(id="login")
	private WebElement loginName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="submit")
    private WebElement userSubmit;
	
	@FindBy(xpath="//DIV[@class='alert alert-info'][text()='Your password has been emailed to you.']")
    private WebElement finalText;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(name="identifier")
	private WebElement gmailId;
	
	@FindBy(name="password")
	private WebElement gmailPassword;
	
	@FindBy(xpath="//*[@class='yW']/span")
	private List<WebElement> passwordMail;
	
	@FindBy(linkText="http://elearning.hommelle.com/main/auth/lostPassword.php?reset=cb4dd9ea6acab6c2d405a5ea8e7e6a213e88c28e&id=126")
	private List<WebElement> passwordLink;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/content")
	private WebElement nextAction1;
	
	@FindBy(xpath="//*[@id=\"passwordNext\"]/content")
	private WebElement nextAction2;
	
	@FindBy(xpath="(//SPAN)[172]")
	private WebElement myPasswordText;
	
	@FindBy(xpath="(//P)[3]")
	private WebElement welcomeText;
	 
	public void clickLostPassword() {
		this.lostPassword.click();
		
	}

	public void enterUsername(String string) {
		this.userName.clear();
		this.userName.sendKeys(string);
		
	}
	
	public void sendLoginName(String string) {
		 	this.loginName.clear();
		 this.loginName.sendKeys(string);
	 
	}

	public void sendPassword(String string) {
		this.password.clear(); 
		this.password.sendKeys(string); 
		
	}
	 
	public void clickSendMsgBtn() {
		this.userSubmit.click();
		
	}

	public void checkMsg() {
		String expectedResult="Your password has been emailed to you.";
		String actualResult = this.finalText.getText();
		Assert.assertEquals(actualResult, expectedResult);
		
	}

	 
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	
	}

	public void loginMyGmail(String string) {
		this.gmailPassword.clear();
		this.gmailPassword.sendKeys(string);
		
	}

	public void checkMailForPassword() {
		
		//this.passwordMail.click();
		try {
		List<WebElement> a =  this.passwordMail;
		System.out.println(a.size());
        for(int i=0;i<a.size();i++){
            System.out.println("Mail is : "+a.get(i).getText());
            if(a.get(i).getText().equals("Site Admin")){  // if u want to click on the specific mail then here u can pass it
                a.get(i).click();
                break;
            }
        }
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
        
        
      
	}
	
	public void checkPasswordLink() {
		
		boolean breakIt = true;
        while (true) {
        breakIt = true;
        try {
        	List<WebElement> c = this.passwordLink;
			System.out.println(c.size());
	        for(int i=0;i<c.size();i++){
	            System.out.println("Mail link is : "+c.get(i).getText());
	            if(c.get(i).getText().contains("http://elearning.hommelle.com")){  // if u want to click on the specific mail then here u can pass it
	                c.get(i).click();
	                break;
	            }
	        }
        } catch (Exception e) {
            if (e.getMessage().contains("element is not attached")) {
                breakIt = false;
            }
        }
        if (breakIt) {
            break;
        }

    }
		
		
	}
	 

	public void loginMyGmailid(String string) {
		this.gmailId.clear();
		this.gmailId.sendKeys(string);
		
	}

	public void clickNext1() {
		this.nextAction1.click();
		
	}

	public void clickNext2() {
		this.nextAction2.click();
		
	}

	public void getPassword() {
		String finalPasswordText;
		boolean breakIt = true;
        while (true) {
        breakIt = true;
        try {
			 finalPasswordText = this.myPasswordText.getText();
		           
        } catch (Exception e) {
        	 finalPasswordText = this.myPasswordText.getText();
            if (e.getMessage().contains("element is not attached")) {
                breakIt = false;
            }
        }
        if (breakIt) {
            break;
        }

    }
		String[] myPassword	 = finalPasswordText.split(":"); 
		System.out.println("Final Password is :"+ myPassword[myPassword.length-1]);
		this.usePassword = myPassword[myPassword.length-1].trim();
	 
		
	}
	
	public void sendPassword() {
		this.password.clear(); 
		this.password.sendKeys(this.usePassword); 
		
	}

}
