package SeleniumWD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelection_06_1 {
	public static void main(String[] args) {									
		String baseURL = "http://demo.guru99.com/test/newtours/register.php";					
        System.setProperty("webdriver.chrome.driver","C:\\Training software 64 bit\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 					
        		
        driver.get(baseURL);					
        Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");

		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);		

    }		
}
