package udemy_workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Perrys\\Documents\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com//locatorspractice//"); //Getting the web page to work on
		/*
		 * logging in by 
		 * inputing the username and password 
		 * and click buttton but with incorrrect details 
		 * to give you an error for the error message 
		 */
		driver.findElement(By.id("inputUsername")).sendKeys("Perrys Ndlovu");
		driver.findElement(By.name("inputPassword")).sendKeys("Muxe123");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //to print out the messsage error
		driver.findElement(By.linkText("Forgot your password?")).click(); //clicking the forgot password button to go to the reset page
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeHolder='Name']")).sendKeys("perrys");
		driver.findElement(By.xpath("//input[@placeHolder='Email']")).sendKeys("perrysndlovu@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0791496840");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div/button[2]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		
		/*
		 * go to the login page and inputing the correct details
		 * then clicking the button to login
		 */
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.cssSelector(".submit")).click();
		

	}

}
