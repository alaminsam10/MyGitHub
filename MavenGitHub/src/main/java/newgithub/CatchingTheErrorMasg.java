package newgithub;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatchingTheErrorMasg {

	@Test
	public  void Error() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ups.com/us/en/Home.page");
//		driver.manage().window().maximize();
		
		WebElement logIn = driver.findElement(By.linkText("Log In"));
		logIn.click();
		WebElement userId = driver.findElement(By.xpath("//input[@type='text']"));
		userId.sendKeys("love10");
		WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
		passWord.sendKeys("2121");
		WebElement submit = driver.findElement(By.id("submitBtn"));
		submit.click();
		
		String actualURL = driver.getCurrentUrl();
		System.out.println("This is the actual URL : "+actualURL);
		
		String expectedURL = "https://www.ups.com/lasso/login";
		System.out.println("This is the expected URL : "+expectedURL);
		
		WebElement errorMasg  = driver.findElement(By.xpath("//*[@id=\"ups-main\"]/div/div/form/p[2]"));
		String str = errorMasg.getText();
		System.out.println(str);
		
		Thread.sleep(2000);
		driver.close();
		
	}
}
