package udemy_workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-active")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) 
		{
			System.out.println("It is disabled");
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
		}
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for (int i = 0; i < 5; ++i) {

			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		WebElement option2 = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Thread.sleep(1000);
		Select option = new Select(option2);
		option.selectByIndex(1);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
