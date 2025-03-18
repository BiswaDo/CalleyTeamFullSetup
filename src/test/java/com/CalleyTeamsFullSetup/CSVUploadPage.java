package com.CalleyTeamsFullSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CSVUploadPage {
	public static WebDriver driver;
  @Test
  @Parameters({"email","psd"})
  public void f(String email, String psd) throws Exception {
	  driver.manage().window().maximize();
	  driver.get("https://app.getcalley.com/Login.aspx");
	  driver.findElement(By.name("txtEmailId")).sendKeys(email);
	  driver.findElement(By.name("txtPassword")).sendKeys(psd);
	  driver.findElement(By.name("btnLogIn")).click();
	  try {
		  mainTask();
	  }catch(Exception e) {
		  Thread.sleep(3000);
		  driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
		  mainTask();
	  }
  }
  
  public void mainTask() throws Exception {
	  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
	  driver.findElement(By.cssSelector("div.wrapper:nth-child(8) div.container div.container:nth-child(4) div.row.mob-view:nth-child(1) div.col-lg-12.col-md-12.col-sm-12.col-12 div.row div.col-lg-4.col-md-12.col-sm-12.col-12:nth-child(1) div.card-box.mb-0.mb-bottom div.content-box div.btn-new:nth-child(3) > a:nth-child(1)")).click();
	  driver.findElement(By.id("ContentPlaceHolder1_txtlistname")).sendKeys("ce");
	  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();
	  driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/label[1]/input[1]")).click();
	  WebElement browse = driver.findElement(By.id("ContentPlaceHolder1_fileUpload"));
	  browse.sendKeys("C:\\Users\\biswa\\Downloads\\Sample_File.csv");
	  driver.findElement(By.id("btnUp")).click();
	  Thread.sleep(7000);
	  WebElement w = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[7]/div[1]/button[1]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(w).click().build().perform();
	  Select s1 = new Select(driver.findElement(By.id("ddlbelongto_1")));
	  s1.selectByVisibleText("FirstName");
	  Select s2 = new Select(driver.findElement(By.id("ddlbelongto_2")));
	  s2.selectByVisibleText("Phone");
	  Select s3 = new Select(driver.findElement(By.id("ddlbelongto_3")));
	  s3.selectByVisibleText("Notes");
	  driver.findElement(By.id("ContentPlaceHolder1_btnUpload")).click();
	  WebElement msg = driver.findElement(By.className("sweet-alert"));
	  if(msg.getText().contains("Data Uploaded Successfully!")) {
		  System.out.println("Succesfully Uploaded!");
	  }else{
		  System.out.println("Not Uploaded! Please try again");
	  }
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\biswa\\OneDrive\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}

