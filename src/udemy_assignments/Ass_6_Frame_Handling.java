package udemy_assignments;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.support.ui.WebDriverWait;

public class Ass_6_Frame_Handling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[contains(text(),'Nested Frames')]")).click();
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);
		WebElement midTopFrame= driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(midTopFrame);
		String text = driver.findElement(By.id("content")).getText();
		System.out.println(text);
		
		

	}

}
