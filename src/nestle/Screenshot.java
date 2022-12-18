package nestle;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\santhosh.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://nestle-in-qa-pwa.ivyretailassist.com/");
		
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//button[@type = \"button\"])[1]")).click();
		
		WebElement input = driver.findElement(By.id("newLoginUserNameForm_userName"));
		
		input.sendKeys("9003594694");
		
		WebElement sigin = driver.findElement(By.xpath("(//button[@type=\"submit\"])"));
		
		sigin.click();
		
		Thread.sleep(5000);
		
		WebElement Menu = driver.findElement(By.xpath("(//i[@class=\"fa fa-bars fa-lg fav-product-header-icon cursor__pointer\"])"));
		
		Menu.click();
		
		Thread.sleep(5000);
		
		WebElement PlaceOrder = driver.findElement(By.xpath("//a[@href=\"/ivy/productList\"]"));
		
		PlaceOrder.click();
		
		Thread.sleep(5000);
		
		File first = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Snaps/img1.png");
		
		FileHandler.copy(first, dest);
		
		Thread.sleep(5000);
		
		Menu.click();
		
		/* WebElement OrderBySmartlist = driver.findElement(By.xpath("//a[@href=\"/ivy/smartList\"]"));
		
		OrderBySmartlist.click();
		
		Thread.sleep(5000);
		
		File OrderSmartlist = ((TakesScreenshot)  driver).getScreenshotAs(OutputType.FILE);
		
		File Smartlist = new File("./Snaps/img2.png");
		
		FileHandler.copy(OrderSmartlist, Smartlist);
		
		driver.quit();*/
	}

}
