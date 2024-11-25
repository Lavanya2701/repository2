package FitPeoAssignment.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FitPeo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void navigationTest() throws Exception{
		MyScreenRecorder.startRecording("navigationTest");
		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		//click on Revenue Calculator
		String value;
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		Thread.sleep(3000);
		//scrolling a page
		WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250);");
		//js.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(6000);
		element.click();
		//entering 560
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		 value= "560";
		element.sendKeys(value);
		//entering 820
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		 value= "820";
			element.sendKeys(value);
			js.executeScript("window.scrollBy(0, 500);");
			//clicking on check boxes
			driver.findElement(By.xpath("//span[contains(text(),'57')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'19.19')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'63')]")).click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0, 500);");
			driver.findElement(By.xpath("//span[contains(text(),'15')]")).click();
			String element1 = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]//p[starts-with(@class,'MuiTypography-root MuiTypography-body1 inter')]")).getText();
			System.out.println(element1);
			String value1 ="$110700";
			Assert.assertEquals(element1, value1);
			System.out.println("Actual:" +element1+ "and expected" +value1+ "values are equal");
		
		MyScreenRecorder.stopRecording();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
