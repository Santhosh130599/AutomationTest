package nestle;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class IFrames {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\santhosh.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://nestle-in-qa.ivyretailassist.com/web/Login");
		
		WebElement LoginID = driver.findElement(By.id("Login_Id"));
		
		LoginID.sendKeys("nestlein.admin");
		
		WebElement Password = driver.findElement(By.id("Password"));
		
		Password.sendKeys("password");
		
		WebElement SiginButton = driver.findElement(By.name("Login"));
		
		SiginButton.click();
		
		// Screenshot //
		
		File Home_Page = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File Destination = new File("./Snaps/Portal_Home_Page.png");
		
		FileHandler.copy(Home_Page, Destination);
		
		// Scheduling SMS//
		
		JavascriptExecutor jse = (JavascriptExecutor) driver ;
		
		WebElement Notification_Menu = driver.findElement(By.xpath("(//a[@class=\"waves-effect waves-cyan collapsible-header\"])[10]"));
		
		jse.executeScript("arguments[0].scrollIntoView()", Notification_Menu);
		
		Notification_Menu.click();
		
		WebElement SMS_Scheduler_Menu = driver.findElement(By.xpath("(//a[@class=\"waves-effect waves-cyan\"])[44]"));
		
		jse.executeScript("arguments[0].scrollIntoView()", SMS_Scheduler_Menu);
		
		SMS_Scheduler_Menu.click();
		
		Thread.sleep(5000);
		
		//Taking Screenshot of SMS Scheduler Screen//
		
		File SMS_Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File EndPoint = new File("./Snaps/SMS_Scheduler.png");
		
		FileHandler.copy(SMS_Screenshot, EndPoint);
		
		//Frames//
		
		driver.switchTo().frame(0);
		
		Thread.sleep(5000);
		
		WebElement AddButton = driver.findElement(By.xpath("(//a[@class=\"waves-effect waves-block waves-light translation-button\"])[1]"));
		
		AddButton.click();
		
		Thread.sleep(5000);
		
		//Taking Screenshot of Scheduler Screen//
		
		File Scheduler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File Screen = new File("./Snaps/Scheduler_Screen.png");
		
		FileHandler.copy(Scheduler, Screen);
		
		// Scheduling SMS in Scheduler Screen//
		
		WebElement Code = driver.findElement(By.id("AMSH_Code"));
		
		Code.sendKeys("SanthoshSandy5");
		
		WebElement Description = driver.findElement(By.id("AMSH_Description"));
		
		Description.sendKeys("SandyOnboard00012345");
		
		Thread.sleep(5000);
		
		WebElement Notification_Type = driver.findElement(By.name("AMSH_NotificationType"));
		
		Select drop = new Select(Notification_Type);
		
		drop.selectByVisibleText("SMS");
		
		WebElement Scheduler_Type = driver.findElement(By.name("AMSH_Schedule_Type"));
		
		Select Schedule = new Select(Scheduler_Type);
		
		Schedule.selectByVisibleText("DATE");
		
		Thread.sleep(5000);
		
		WebElement NextButton = driver.findElement(By.xpath("(//button[@class=\"btn waves-effect waves-light\"])[3]"));
		
		NextButton.click();
		
		WebElement Message_Type = driver.findElement(By.name("MessageTypeIds"));
		
		Select Type = new Select(Message_Type);
		
		Type.selectByVisibleText("ONBRD_SMS");
		
		WebElement Template_Name = driver.findElement(By.id("TemplateTypeIds"));
		
		Select Template = new Select(Template_Name);
		
		Template.selectByVisibleText("Template 01");
		
		WebElement Next = driver.findElement(By.xpath("(//button[@class=\"btn waves-effect waves-light\"])[6]"));
		
		Next.click();
		
		
		
		
		
				
		
	}

}
