package udemy_workspace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// chrome.exe --> Chrome browser
		/*
		 * There is a step to invoke chrome driver however we have something called
		 * selenium manager which help in getting the appropriate driver for a browser
		 * to communicate with the actual product
		 */
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Perrys\\Documents\\chromedriver-win64\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver(); -this is for Chrome

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Perrys\\Documents\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/");
		System.out.println("Title: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());
		driver.quit();

	}

}
