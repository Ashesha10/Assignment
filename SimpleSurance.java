package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SimpleSurance {
	public static WebDriver driver;

	/*
	 
	 This method will launch the browser for chrome.
	 
	 */	
	@Test(priority = 1)
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/jars/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.schutzklick.de/iphone-versicherung");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	/*
	 
	 This method will perform all the actions of selecting a phone and price.
	 
	 */
	@Test(priority = 2)
	public void selectPhone() {

		WebElement model = driver.findElement(By.xpath(".//*[@id='productForm']/div[1]/div[1]/div/button"));
		Actions actions = new Actions(driver);
		actions.moveToElement(model).click().perform();
		driver.findElement(By.xpath(".//*[@id='productForm']/div[1]/div[2]/div/ul/li[4]/a")).click();
		WebElement price = driver.findElement(By.xpath(".//*[@id='productForm']/div[2]/div[1]/div/button"));
		actions.moveToElement(price).click().perform();
		driver.findElement(By.xpath(".//*[@id='productForm']/div[2]/div[2]/div/ul/li[3]/a/span[1]")).click();
		driver.findElement(By.id("periodOption24")).click();
		WebElement checkBox = driver.findElement(By.xpath(".//*[@id='theftOption']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", checkBox);
		checkBox.click();
		driver.findElement(By.xpath(".//*[@id='productFormSubmit']")).click();

	}

}
