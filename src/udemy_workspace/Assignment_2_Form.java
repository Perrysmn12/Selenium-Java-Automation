package udemy_workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_2_Form {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Perrys Ndlovu");
		driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("muxendlovu098@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Muxe@12");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		
		WebElement staticdrop =driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select drop = new Select(staticdrop);
		drop.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("07/01/2005");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		/*
		String  msg = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		System.out.println(msg.replace("×", " ").trim());
		*/
		String[]  msg = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText().split("\n");
		System.out.println(msg[1]);
		


	
	}
	

}
