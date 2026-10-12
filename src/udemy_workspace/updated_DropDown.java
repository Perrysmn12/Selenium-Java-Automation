package udemy_workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updated_DropDown {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		// Count number of elements
		System.out.println("Size: " + driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
		
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		//getDomAttribute - get the value of a given attribute
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		/*
		 * If you want to see whether an element is disabled or Enabled you have to 
		 * check that one variable that changes when you click on that element to check
		 * then use it for the condition to determine whether if its enabled or not 
		 */
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) 
		{
			System.out.println("Is Enabled"  );
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}
		
		
		
		
		

		/*
		 * Clicking checkboxes and checking whether it is checked or not
		 */

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());

		// System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);

		int i = 1;
		/*
		 * while (i < 5) { driver.findElement(By.id("hrefIncAdt")).click(); i += 1;
		 * //i++; }
		 */
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

	}

}
