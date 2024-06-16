package DevOps_Assignment;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;

public class CrossBrowser {

		WebDriver driver;
		
		@Parameters({"browser"})
		@Test (priority=1)
		
		public void BrowserTest (String browser) throws InterruptedException {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chromedriver", "C:\\Users\\mayur.t\\OneDrive - Trinity Mobility Pvt Ltd\\Desktop\\Chrome driver\\chromedriver-win124\\chromedriver.exe");
			    driver=new ChromeDriver();
			    System.out.println("Chrome Browser is open");
				
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", "C:\\Users\\mayur.t\\OneDrive - Trinity Mobility Pvt Ltd\\Desktop\\Chrome driver\\FirefoxDriver\\geckodriver.exe");
			    driver=new FirefoxDriver();
			    System.out.println("FireFox Browser is open");
			}else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.firefox.driver", "C:\\Users\\mayur.t\\OneDrive - Trinity Mobility Pvt Ltd\\Desktop\\Chrome driver\\EdgeDriver\\msedgeodriver.exe");
			    driver=new EdgeDriver();
			    System.out.println("Edge Browser is open");
		   }else {
			  
			   System.out.println("Wrong browser selction");
			   
		   }
			
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			Thread.sleep(5000);
		   }
	
	
	@Test (priority=2)
		public void VerifyCurrentUrl () throws InterruptedException {
			AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/");
			
			Thread.sleep(5000);
			}
		
		@Test(priority=3)
		public void close() {
			driver.quit();
		}
			
		
			
		
		}
		


