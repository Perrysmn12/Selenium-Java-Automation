package udemy_workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggest_DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		/*
		 * send key to the input field on what you wanna search
		 */
		driver.findElement(By.id("autosuggest")).sendKeys("so");
		Thread.sleep(3000);
		/*
		 * DON'T FORGET TO RIGHT CLICK THE DROP DOWN SO YOU CAN FIND THE COMMON ATTRIBUTE TO USE TO GET ALL THE AVAILABLE DROPDOWNS
		 * list that will be available have one common attribute and with that attribute 
		 * we will use it to give us all the available options that were present
		 * and we store in a variable that is of List <WebElement> type
		 */
		List<WebElement> options = driver.findElements(By.cssSelector("li[class$='ui-menu-item'] a"));
		/*
		 * Here we iterate through each element store in our web element (option ) in this case
		 * then we check the IF condition whether it matches with out text
		 */
		for(WebElement option: options) 
		{
			if(option.getText().equalsIgnoreCase("South Africa")) 
			{
				option.click();
				break;
			}
			
		}

	}

}
