package com.CalleyTeamsFullSetup;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LoginPage {
	public static WebDriver driver;
  @Test
  @Parameters({"email","psd"})
  public void f(String email, String pwd) throws Exception {
	  driver.get("https://app.getcalley.com/Login.aspx");
	  driver.findElement(By.name("txtEmailId")).sendKeys(email);
	  driver.findElement(By.name("txtPassword")).sendKeys(pwd);
	  driver.findElement(By.name("btnLogIn")).click();
	  String currentURL= driver.getCurrentUrl();
	  String ExpectedURL = "https://app.getcalley.com/dashboard_teams.aspx";
	  if(currentURL.equals(ExpectedURL)) {
		  System.out.println("Logged in!");
	  }else {
		  System.out.println("Not Logged in!");
	  }
	  driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\biswa\\OneDrive\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  

@AfterMethod
  public void After() throws InterruptedException{
	  Thread.sleep(6000);
	  driver.quit();
  }
}

