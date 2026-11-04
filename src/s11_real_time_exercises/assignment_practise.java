package s11_real_time_exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//click any checkbx and grab the text
		driver.findElement(By.id("checkBoxOption2")).click();
		String text= driver.findElement(By.cssSelector("label[for='benz']")).getText();
		
		/*
		 * select an option and the name should come from the text
		 * checkbox text
		 */
		
		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText(text);
		
		/*
		 * grab the text from the checkbox and enter it in the input box 
		 *and verify whether it appear in the alert message
		 */
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String confirm = driver.switchTo().alert().getText();
		if(confirm.contains(text)) 
		{
			System.out.println("Everything is fine");
		}
		else
			System.out.println("Error: Text not available");
		
		driver.switchTo().alert().accept();
			
		
		
		
		

	}

}
