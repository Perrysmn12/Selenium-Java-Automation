package s11_real_time_exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class handling_Calender_UI_in_ECommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String day = "15";
		String monthNumber = "6";
		String year = "2027";
		String[] expectedList = {monthNumber,day,year};

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year"))
				.click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
		
		List<WebElement> actualList =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i =0;i<actualList.size();i++) 
		{
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
		}
		driver.close();
	}

}
