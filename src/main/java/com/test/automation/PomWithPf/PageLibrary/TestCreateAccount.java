package com.test.automation.PomWithPf.PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCreateAccount {
	WebDriver driver;
	
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement ClickSignIn;
	
	@FindBy(id="email_create")
	WebElement EmailCreate;
	
	@FindBy(name="SubmitCreate")
	WebElement CreateAccount;
	
	@FindBy(how=How.XPATH,using="//div[@id='create_account_error' or @li='Invalid email']")
	WebElement CreteAccountError;
	
	public TestCreateAccount(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonSignin(){
		ClickSignIn.click();
		
	}
	
	public void AccountCreate(String email){
		EmailCreate.sendKeys(email);
		CreateAccount.click();
	}
	public String ElementError(){
		return CreteAccountError.getText();
	}

}
