/*Write a script to open google.com and verify that title is Google and also verify that it is redirected
to google.co.in.*/

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\santhosh.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		
		if(title.equals("Google")) {
			
			System.out.println("Pass: Title is matched :" +title);
			
		}
		
		else
		{
		System.out.println("Fail : Title not matched :" +title);
		}
		
		String url = driver.getCurrentUrl();
		
		if(url.contains("www.google.com")) {
			
			System.out.println("Pass: URL  is matched :" +url);
			
		}
		
		else
		{
		System.out.println("Fail : URL not matched :" +url);

		}
		
		driver.quit();
	}

}
