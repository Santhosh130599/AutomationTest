package nestle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sorting {

	public static void main(String[] args) throws InterruptedException {

		
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
		
		WebElement sort = driver.findElement(By.xpath("//span[text()='Price High To Low']"));
		
		sort.click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("window.scrollBy(0,400);");
		
		WebElement sorting = driver.findElement(By.xpath("//span[text()='Apply']"));
		
		sorting.click();
		
		Thread.sleep(5000);
		
		WebElement ProductName = driver.findElement(By.xpath("//h4[text()='MILKMAID Prtsk SCM EOE Tin 48x400g IN']"));
		
		Thread.sleep(5000);
		
		jse.executeScript("arguments[0].scrollIntoView()", ProductName);
		
		Thread.sleep(6000);
		
		ProductName.findElement(By.xpath("(//span[@class=\"card-plus-sign\"]) [31]")).click();
		
		WebElement AddtoCart = driver.findElement(By.xpath("(//span[text()='Add to cart'])"));
		
		AddtoCart.click();
		
		Thread.sleep(7000);
		
		/*Menu.click();
		
		WebElement Mycart = driver.findElement(By.xpath("(//a[@href=\"/ivy/viewCart\"]) [3]"));
		
		Mycart.click();
		
		Thread.sleep(6000);
		
		WebElement Placeorder = driver.findElement(By.xpath("(//span[text()='Place Order'])[2]"));
		
		Placeorder.click();*/
		
		
	}

}
