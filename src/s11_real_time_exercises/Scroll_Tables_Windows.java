package s11_real_time_exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll_Tables_Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(5000);
		// js.executeAsyncScript("document.querySelector(.tableFixHead).scrollTop=500");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Sum: " + sum);
		driver.findElement(By.cssSelector(".totalAmount"));
		int actualTotal =Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(actualTotal, sum);

	}

}
