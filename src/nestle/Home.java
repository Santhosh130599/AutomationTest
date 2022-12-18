package nestle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\santhosh.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://nestle-in-qa-pwa.ivyretailassist.com/");
		
		Thread.sleep(5000);
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//button[@type = \"button\"])[1]")).click();
		
		WebElement input = driver.findElement(By.id("newLoginUserNameForm_userName"));
		
		input.sendKeys("9003594694");
		
		WebElement sigin = driver.findElement(By.xpath("(//button[@type=\"submit\"])"));
		
		sigin.click();
		
		Thread.sleep(5000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		// Verify Best Selling Products//
		
		jse.executeScript("window.scrollBy(0,2197);");
		
		Thread.sleep(5000);
		
		WebElement Best_Sellinmg_Products = driver.findElement(By.xpath("//h6[text()='Best Selling Products']"));
		
		boolean Displayed = Best_Sellinmg_Products.isDisplayed();
		
		
		if (Displayed) {
			
			System.out.println("Best Selling Products Displayed in Home Page");
			
		}
		
		else
		{
			System.out.println("Best Selling Porducts Not Displayed in Home page");
		}
		
		// Verify Recommended for You//
		
		jse.executeScript("window.scrollBy(0,-800);");
		
		Thread.sleep(5000);
		
		WebElement Recommended_For_You = driver.findElement(By.xpath("//h6[text()='Recommended For  You']"));
		
		boolean Display = Recommended_For_You.isDisplayed();
		
		
		if (Display) {
			
			System.out.println("Recommended For  You Displayed in Home Page");
			
		}
		
		else
		{
			System.out.println("Recommended For  You Not Displayed in Home page");
		}
		
		//Verify Offer Zone //
		
		jse.executeScript("window.scrollBy(0,-500);");
		
		Thread.sleep(5000);
		
		WebElement Offer_Zone = driver.findElement(By.xpath("//h6[text()='Offer Zone']"));
		
		boolean Visible = Offer_Zone.isDisplayed();
		
		
		if (Visible) {
			
			System.out.println("Offer Zone Displayed in Home Page");
			driver.quit();
			
		}
		
		else
		{
			System.out.println("Offer Zone Not Displayed in Home page");
		}
		
		
		
		
	}

}
