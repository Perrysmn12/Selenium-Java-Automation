package automate_ajax_s10;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class action_Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions a = new Actions(driver);

		//click an input tag to write characters in capital letters
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

		WebElement moveCursor = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
		// Move the cursor to an element
		a.moveToElement(moveCursor).contextClick().build().perform();

	}

}
