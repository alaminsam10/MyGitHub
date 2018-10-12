package newgithub;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups {
	
	@Test
	public void Popups() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/delete_customer.php ");
//		driver.manage().window().maximize();
		
		WebElement customerId = driver.findElement(By.xpath("//input[@type='text']"));
		customerId.sendKeys("2121");
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.submit();
		
		Alert alert = driver.switchTo().alert();
		
		String alertMasg = driver.switchTo().alert().getText();
		System.out.println(alertMasg);
		Thread.sleep(2000);
		
		alert.accept();
		Thread.sleep(2000);
		
		driver.close();
	}

}
