package kelloggs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderPlacing {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\santhosh.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kelloggs-in-qa-pwa.ivyretailassist.com/");
		
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement input = driver.findElement(By.id("newLoginUserNameForm_userName"));
		
		input.sendKeys("9632790796");
		
		WebElement sigin = driver.findElement(By.xpath("(//button[@type=\"submit\"])"));
		
		sigin.click();
		
		Thread.sleep(7000);
		
		WebElement Menu = driver.findElement(By.xpath("(//i[@class=\"fa fa-bars fa-lg fav-product-header-icon cursor__pointer\"])[2]"));
		
		Menu.click();
		
		Thread.sleep(5000);
		
		WebElement PlaceOrder = driver.findElement(By.xpath("//a[@href=\"/ivy/productList\"]"));
		
		PlaceOrder.click();
		
		Thread.sleep(5000);
		
	}

}
