package Customer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "C://Users//4082//Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		String baseurlString = ("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		driver.get(baseurlString);

		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Bank Manager Login']")));
		WebElement Manager = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
		builder.moveToElement(Manager);
		builder.click();
		builder.perform();

		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait0.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='addCust()']")));
		WebElement acBtn= driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
		builder.moveToElement(acBtn);
		builder.click().perform();
		
		//driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys("Sidra");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='fName']")));
		WebElement firstName= driver.findElement(By.xpath("//input[@ng-model='fName']"));
		builder.moveToElement(firstName);
		firstName.sendKeys("SidraTulMuntaha");
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='lName']")));
		WebElement lastName= driver.findElement(By.xpath("//input[@ng-model='lName']"));
		builder.moveToElement(firstName);
		lastName.sendKeys("M Abbas");
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='postCd']")));
		WebElement code= driver.findElement(By.xpath("//input[@ng-model='postCd']"));
		builder.moveToElement(code);
		code.sendKeys("123");
		
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		WebElement AddCustomer= driver.findElement(By.xpath("//button[@type='submit']"));
		builder.moveToElement(AddCustomer).click().perform();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
	
	@Test(priority = 0)
	public void OpenAccount() {
		System.setProperty("webdriver.chrome.driver", "C://Users//4082//Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		String baseurlString = ("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		driver.get(baseurlString);
		
		Actions builder = new Actions(driver);
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait0.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ng-click='openAccount()']")));
		WebElement openAcc= driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
		builder.moveToElement(openAcc);
		builder.click().perform();
		
		
		
	}
	
}
