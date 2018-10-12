package newgithub;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	@Test
	public void Windows() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.javatpoint.com/java-tutorial");
//		driver.manage().window().maximize();
		
		WebElement click = driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/span/a"));
		click.click();
		
		String parentURL = driver.getCurrentUrl();
		System.out.println("This is the main URL : "+parentURL);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		
		int size = s1.size();
		System.out.println("There are "+size+" windows.");
		
		for(String handle:s1) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				String childURL = driver.getCurrentUrl();
				System.out.println("This is the child window URL : "+childURL);
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
