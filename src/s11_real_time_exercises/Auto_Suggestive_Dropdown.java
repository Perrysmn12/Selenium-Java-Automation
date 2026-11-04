package s11_real_time_exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Auto_Suggestive_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String key = "sou";
		String country = "South Africa";

		driver.findElement(By.id("autocomplete")).sendKeys(key);
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));

		for (WebElement values : list) {
			String optionText = values.getText();
			if (values.getText().contains(country)) {
				values.click();

				System.out.println("Country: " + optionText);

				break;
			}
		}

	}

}
