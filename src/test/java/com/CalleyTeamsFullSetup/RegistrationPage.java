package com.CalleyTeamsFullSetup;


import java.time.Duration;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class RegistrationPage {
	public static WebDriver driver;
@Test
  @Parameters({"Name","Email","Pwd","Mobile"})
  public void Registration(String name, String email, String pwd, String num ) throws InterruptedException {
		driver.get("https://app.getcalley.com/registration.aspx");
		driver.findElement(By.name("txtName")).sendKeys(name);
		driver.findElement(By.name("txtEmail")).sendKeys(email);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.name("txt_mobile")).sendKeys(num);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Actions actions = new Actions(driver);
		WebElement checkbox = driver.findElement(By.id("checkbox-signup"));
		actions.moveToElement(checkbox).click().perform();
		driver.findElement(By.id("btnSignUp")).click();
		WebElement btn = driver.findElement(By.xpath("//button[@class='confirm']"));
		actions.moveToElement(btn).click().perform();
		//manually input otp
		driver.findElement(By.name("btnSignUp")).click();   //bug -> it keep sending otp and not verifying
  }
  
  @Test(enabled=false)
  public void skipCaptcha() {
	  driver.findElement(By.id("rc-anchor-container")).click();//doing it manually
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
