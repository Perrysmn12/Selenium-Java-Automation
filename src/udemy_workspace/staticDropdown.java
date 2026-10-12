package udemy_workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
			
		/*
		 * the variable is to tell us where we are gonna
		 *  find the select tagname that we are gonna work on
		 */
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		/*
		 *  if the tagname of a dropdown is select it means it is static.
		 *  the select object requires an argument that we'll tell it where to find
		 *  the drop-down and from there we will work on that drop don
		 *  using the object created
		 */
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

 }

}
