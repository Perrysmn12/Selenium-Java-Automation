package s11_real_time_exercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1.count all links of the page
		 * 2.count all the footer section links of the page
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Whole Page: " + driver.findElements(By.tagName("a")).size());
		
		//limiting the scope of our webdriver to the footer section
		WebElement footerDriver =driver.findElement(By.id("gf-BIG"));
		System.out.println("Footer Sections: "+footerDriver.findElements(By.tagName("a")).size());
		
		//limiting the scope of our webdriver to the footer section first column
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("First Column: " + columnDriver.findElements(By.tagName("a")).size());
		
		//click every link on the first column and get the title of each link
		
		for(int i =1;i<columnDriver.findElements(By.tagName("a")).size();++i) 
		{
			
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);
			
		}
		
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		/*
		 * Checks whether there's any tab/window open including 
		 * the current main page or rather starting with the main page
		 * switches to the first tab by the(it.next())
		 * then getting the titles of them
		 */
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
