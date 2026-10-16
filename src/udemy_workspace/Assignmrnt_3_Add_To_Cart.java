package udemy_workspace;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmrnt_3_Add_To_Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// A normal Array
		String[] items = { "Brocolli", "Cucumber", "Beetroot" };
		addItems(driver, items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active'] //div[@class='action-block']/button")).click();
		//driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		

	}

	public static void addItems(WebDriver driver, String[] items) throws InterruptedException {
		int z = 0;

		/*
		 * we find all of the items and store them /in a productname of type list
		 * webelement
		 */

		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));

		/*
		 * With this for loop we are going to iterate through each element and we are
		 * going to create a variable of String type using the productnames from the
		 * current position and get the text of it and we change the normal array to an
		 * arrayList and then we'll chech whether the current position matches with our
		 * items needed then click the button of that position
		 * 
		 * 
		 */
		Thread.sleep(3000);
		for (int i = 0; i < productNames.size(); i++) {
			String[] itemReturned = productNames.get(i).getText().split("-");
			String formattedName = itemReturned[0].trim();

			List<String> itemNeeded = Arrays.asList(items);

			if (itemNeeded.contains(formattedName)) {
				z += 1; // z++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click(); INCONSTISTENT LOCATOR

				if (z == items.length) {
					break;
				}
			}

		}
	}

}
