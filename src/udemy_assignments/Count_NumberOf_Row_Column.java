package udemy_assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Count_NumberOf_Row_Column {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1.Count Number of Row and Column 2.Print second row of the table
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");

		// Limiting the scope of my driver
		WebElement table = driver.findElement(By.xpath("//div[@class='left-align'] //table[@id='product']"));
		// Number of Rows
		System.out.println("Number Of Row: " + table.findElements(By.xpath(".//tr")).size());
		// Number Of Column
		System.out.println("Number Of Column: " + table.findElements(By.xpath(".//th")).size());
		// Print second Row of the table
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());

	}

}