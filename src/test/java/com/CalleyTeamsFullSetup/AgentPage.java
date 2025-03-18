package com.CalleyTeamsFullSetup;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AgentPage {
	public static WebDriver driver;
  @Test
  @Parameters({"email","psd", "Name","mobile","email-sub","pwd",})
  public void f(String email, String psd,String name, String num, String d_email, String pwd) throws InterruptedException {
	  driver.manage().window().maximize();
	  driver.get("https://app.getcalley.com/Login.aspx");
	  driver.findElement(By.name("txtEmailId")).sendKeys(email);
	  driver.findElement(By.name("txtPassword")).sendKeys(psd);
	  driver.findElement(By.name("btnLogIn")).click();
	 try {
		 mainTask(name, num, d_email, pwd);
	 }catch(Exception e) {
		 Thread.sleep(3000);
		 driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
		 mainTask(name, num, d_email, pwd);
	 }
  }
  
  public void mainTask(String name, String num, String d_email, String pwd) {
	  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")).click();
	  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
	  
	  driver.findElement(By.id("ContentPlaceHolder1_txt_name")).sendKeys(name);
	  driver.findElement(By.id("ContentPlaceHolder1_txt_mobile")).sendKeys(num);
	  driver.findElement(By.id("ContentPlaceHolder1_txt_email")).sendKeys(d_email);
	  driver.findElement(By.id("ContentPlaceHolder1_txt_pass")).sendKeys(pwd);
	  driver.findElement(By.id("ContentPlaceHolder1_btn_submit")).click();
	 WebElement w = driver.findElement(By.xpath("//p[contains(text(),'Agent Added Successfully!')]"));
	  if(w.getText().equals("Agent Added Successfully!")) {
		  System.out.println("submited!");
	  }else {
		  System.out.println("Not Submitted!, Try again");
	  }
	  driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\biswa\\OneDrive\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
}
