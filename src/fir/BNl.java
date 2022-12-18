package fir;

public class BNl {
	
	package retail_assist

	import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
	import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
	import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
	import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
	import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

	import com.kms.katalon.core.annotation.Keyword
	import com.kms.katalon.core.checkpoint.Checkpoint
	import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
	import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
	import com.kms.katalon.core.model.FailureHandling
	import com.kms.katalon.core.testcase.TestCase
	import com.kms.katalon.core.testdata.TestData
	import com.kms.katalon.core.testobject.TestObject
	import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
	import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
	import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

	import internal.GlobalVariable

	import org.openqa.selenium.By as By
	import org.openqa.selenium.WebDriver as WebDriver
	import org.openqa.selenium.WebElement as WebElement
	import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

	import java.sql.DriverManager
	import java.sql.ResultSet
	import java.sql.Statement
	import org.postgresql.jdbc.PgConnection as PgConnection

	import org.openqa.selenium.chrome.ChromeDriver
	import org.openqa.selenium.chrome.ChromeOptions
	import org.openqa.selenium.remote.DesiredCapabilities


	public class PWA {

		@Keyword
		public String Signup() {


			WebUI.navigateToUrl(GlobalVariable.PWA_URL)

			WebUI.waitForElementVisible(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Add shortcut pop cancel button'), 30)


			if (WebUI.verifyElementVisible(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Add shortcut pop cancel button'), FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Add shortcut pop cancel button'))
			}

			WebUI.waitForElementVisible(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Distributor-Retailer Code field'), 0)

			WebUI.setText(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Distributor-Retailer Code field'), findTestData(
					'PWA App/Login/Safee/PWA login Details').getValue('Mobile_Number', 3))

			WebUI.setText(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Mobile number Field'), findTestData('PWA App/Login/Safee/PWA login Details').getValue(
					'Mobile_Number', 3))

			WebUI.delay(5)

			WebUI.click(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Sign-up button'))


			String retailerCode = WebUI.getAttribute(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Distributor-Retailer Code field'),
					'value')

			String mobileNo = WebUI.getAttribute(findTestObject('PWA App/Retailer Onboarding/Safee/Sign-Up Screen/Mobile number Field'), 'value')

			String LoginID
			if (retailerCode!=mobileNo) {
				LoginID=retailerCode
			}
			else {
				LoginID=mobileNo
			}

			println LoginID

			return LoginID
		}

		@Keyword
		public String getOTP(String LoginID){

			PgConnection connection = null

			String url = findTestData('DB INFo/DB login info').getValue(1, 1)

			String dbname = findTestData('DB INFo/DB login info').getValue(2, 1)

			String port = findTestData('DB INFo/DB login info').getValue(3, 1)

			String username = findTestData('DB INFo/DB login info').getValue(4, 1)

			String password = findTestData('DB INFo/DB login info').getValue(5, 1)

			//Load driver class for your specific database type
			String conn = (((('jdbc:postgresql://' + url) + ':') + port) + '/') + dbname

			if ((connection != null) && !(connection.isClosed())) {
				connection.close()
			}

			connection = DriverManager.getConnection(conn, username, password)

			Statement stm = connection.createStatement()

			String searchData = ('\'' + LoginID) + '\''

			//select "SU_Otp" from "SADM_Users" where "SU_Login_Id" ='8072503134' order by "SU_Otp_Valid_From" asc fetch first 1 row only
			String queryString = (('select "SU_Otp" from "SADM_Users" where "SU_Login_Id" =' + searchData) + ' order by "SU_Otp_Valid_From" asc fetch first 1 row only ')

			println(queryString)

			ResultSet rs = stm.executeQuery(queryString)

			def recordSet = rs
			String OTPValue

			while (recordSet.next()) {
				Object dbOTP = recordSet.getObject('SU_Otp')

				OTPValue = dbOTP.toString()

			}

			return OTPValue

		}

		
		public static void getMobile(){

			String deviceName = findTestData('Device info/Device details').getValue(1, 1)

			System.setProperty('webdriver.chrome.driver', '.\\Drivers\\chromedriver_win32\\chromedriver.exe')

			Map<String, String> mobileEmulation = new HashMap<String, String>()

			//mobileEmulation.put('deviceName', 'Galaxy Note 3')

			println deviceName

			mobileEmulation.put('deviceName', deviceName)

			Map<String, Object> chromeOptions= new HashMap<String, Object>()

			chromeOptions.put('mobileEmulation', mobileEmulation)

			DesiredCapabilities caps = DesiredCapabilities.chrome()

			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions)

			WebDriver driver = new ChromeDriver(caps)

			DriverFactory.changeWebDriver(driver)

			driver.manage().window().maximize()

		}
	}




}
