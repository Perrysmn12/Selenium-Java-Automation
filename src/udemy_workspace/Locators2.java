package udemy_workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
 
public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Perrys\\Documents\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name="rahul";
		String password = getPassword(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com//locatorspractice//");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText() ,"Hello "+name+",");
        driver.findElement(By.xpath("//*[text()=\"Log Out\"]")).click();
        driver.quit();


	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com//locatorspractice//");
		driver.findElement(By.linkText("Forgot your password?")).click(); //clicking the forgot password button to go to the reset page
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/button[2]")).click();
		Thread.sleep(1000);
		//Please use temporary password 'rahulshettyacademy' to Login.  this is the text 
		String passwordText = driver.findElement(By.xpath("//form/p")).getText(); //we store the text in a String variable
		String password = passwordText.split("'")[1]; // we split the variable and store it in another variable to make it an array and  choose index 1 as our new variable
		
		return password;
		
	}

}
