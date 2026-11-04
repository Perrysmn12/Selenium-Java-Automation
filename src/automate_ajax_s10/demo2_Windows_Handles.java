package automate_ajax_s10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo2_Windows_Handles {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		driver.findElement(By.xpath("//a[@class='blinkingText'] [1]")).click();

		// stores all our windows tabs opened by the automation
		Set<String> windows = driver.getWindowHandles();

		// iterator is to iterate through the windows the automation opened
		Iterator<String> it = windows.iterator();

		String parentId = it.next();// this access the parent window
		String childId = it.next();// this access the childs
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		// System.out.println(driver.findElement(By.xpath("//a[contains(text(),'mentor')]")).getText());
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
