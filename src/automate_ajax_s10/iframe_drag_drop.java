package automate_ajax_s10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iframe_drag_drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		Actions a = new Actions(driver);
		WebElement frame1 =driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		/*
		 * the argument can be an integer like the index of the frmae
		 * or a web element of the frame
		 * 
		 */
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source ,target).build().perform();
		//driver.switchTo().defaultContent();
		
		
		
		

	}

}
