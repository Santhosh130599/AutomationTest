package nestle;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_Page {

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
		
		
		
		// Verify the elements in the Home Page//

		WebElement OfferZone = driver.findElement(By.xpath("//h6[text()='Offer Zone']"));
		
		boolean Displayed = OfferZone.isDisplayed();
		
		System.out.println("Offer Zone Displayed in Home page :" +Displayed);
		
		// Verify the Recommended For You in Home Page//
		
		WebElement RecommendedForYou = driver.findElement(By.xpath("//h6[text()='Recommended For  You']"));
		
		boolean Display = RecommendedForYou.isDisplayed();
		
		System.out.println("RecommendedForYou Displayed in Home page :" +Display);
		
		// Verify the Best Selling Products in Home page//
		
		
		WebElement BestSellingProducts = driver.findElement(By.xpath("//h6[text()='Best Selling Products']"));
		
		boolean Visible = RecommendedForYou.isDisplayed();
		
		System.out.println("BestSellingProducts Displayed in Home page :" +Visible);
		
		
	}
}
