package com.test.automation.PomWithPf.CreateAccount;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.PomWithPf.DataProviderLibrary.ComnDataprovider;
import com.test.automation.PomWithPf.PageLibrary.TestCreateAccount;
import com.test.automation.PomWithPf.TestBase.TestBase1;

public class TC001_CreateAnAccount extends TestBase1{
	TestCreateAccount TCA;
	
	@BeforeClass
	@Override
	public void initialise() throws IOException {
		// TODO Auto-generated method stub
		super.initialise();
	}
	@Test(dataProviderClass=ComnDataprovider.class,dataProvider="createaccount")
	public void CreateAcc(String email,String runmode) throws InterruptedException{
		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode is N, I will not execute this test");
		}else
		try{
		if(email.equals(null)){
			return;
		}}catch(Exception e){
			e.getMessage();
		}
		TCA= new TestCreateAccount(driver);
		TCA.ClickonSignin();
		TCA.AccountCreate(email);
		GetScreenshot("CreateAcc"+email);
		Thread.sleep(10000l);
		Assert.assertEquals(TCA.ElementError(), "Invalid email address.");
	
	}
	@AfterClass
	public void endtest(){
		driver.close();
	}

}
