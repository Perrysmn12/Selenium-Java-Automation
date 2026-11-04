package udemy_assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_4_Explicit_implementation {
	private static WebDriver driver = new ChromeDriver();
	private static WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		String[] itemsRequired = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		int j=0;
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		logIn();
		addToCart(itemsRequired,j);
		checkout();
		purchase();
		System.out.println("**************");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success.alert-dismissible")));
		String[] msg = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText().split("x");
		System.out.println(msg[0]);
		
		
		
		
		
		

	}
	
	public static void logIn() {

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy"); //username
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2"); //password
		driver.findElement(By.xpath("//input[@value='user']")).click();//clicking radio button 
		
		/*
		 * Getting an alert message text and
		 * pressing Okay
		 */
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body'] /p")));
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-body'] /p")).getText());
		driver.findElement(By.id("okayBtn")).click();
		
		//Select User Type
		Select option = new Select(driver.findElement(By.xpath("//div[@class='form-group'] //select[@class='form-control']")));
		option.selectByIndex(0);
		driver.findElement(By.cssSelector("input[id*='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
	}
	public static void addToCart(String[] itemsRequired,int j) { 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
		List<WebElement> itemsAvailable = driver.findElements(By.xpath("//h4[@class='card-title']"));
		List<String> itemNeeded = Arrays.asList(itemsRequired);
		
		for(int i =0;i<itemsAvailable.size();i++) 
		{
			if(itemNeeded.contains(itemsAvailable.get(i).getText())) 
			{
				j++;
				driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
				if(j==itemNeeded.size()) 
				{
					break;
				}
				
			}
		}
		
	}
	public static void checkout() { 
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-success']")));
		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
	}
    public static void purchase() {
    	w.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
    	driver.findElement(By.id("country")).sendKeys("South Africa");
    	
    	
    	driver.findElement(By.cssSelector(".btn.btn-success.btn-lg")).click();
    	
    }
}
