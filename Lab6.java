zzpackage Lab6TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab6 {
	public String baseurl = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;

	@BeforeTest
	public void GetDriverAdress() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ACER\\Desktop\\CureMD\\QA_Automation\\Java\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\4123\\Downloads\\chromedriver.exe");

	}

	@BeforeMethod
	public void GetURLInitObjects() {

		// Create New WebDriver and maximize it
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);

		// Create Actions & Wait Objects
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@AfterMethod
	public void CloseURL() {
		driver.close();

	}

	// Quick Access Functions Are Listed Below 
	public void ActionsClick(WebElement elem) {
		actions.click(elem).perform();
	}

	public void ActionsClickAndHold(WebElement elem) {
		actions.clickAndHold(elem).perform();
	}

	public WebElement WaitXpath(String xpath) {
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return elem;
	}

	public void HomeButtonClick() {
		// ActionsWaitClick("//button[@class='btn btn-default']");
		WebElement homeBut = WaitXpath("//button[@ng-click='home()']");
		ActionsClick(homeBut);
	}

	public void AlertAccept() {
		driver.switchTo().alert().accept();
	}

	public void SubmitButtonClick() {
		WebElement submitBut = WaitXpath("//button[@type='submit']");
		ActionsClick(submitBut);
	}
	
	//Test Cases Start Here
	@Test(priority = 0)
	public void ManagerAddCustomer() {

		// Hit Manager Button To Login After Wait
		WebElement managerButton = WaitXpath("//button[@ng-click='manager()']");
		ActionsClick(managerButton);

		// Hit Add Customer After Wait
		WebElement addCustomer = WaitXpath("//button[@ng-click='addCust()']");
		ActionsClick(addCustomer);

		// Add Customer Details and Handle Alert
		WebElement fName = WaitXpath("//input[@ng-model='fName']");
		fName.sendKeys("Malik");
		WebElement lName = WaitXpath("//input[@ng-model='lName']");
		lName.sendKeys("Ajay");
		WebElement postCode = WaitXpath("//input[@ng-model='postCd']");
		postCode.sendKeys("4123");
		WebElement addCustBut = WaitXpath("//button[@class='btn btn-default']");
		ActionsClick(addCustBut);
		AlertAccept();
	}

	@Test(priority = 1)
	public void OpenCustomerAccount() {

		ManagerAddCustomer();

		// Hit Open Account
		WebElement openAcc = WaitXpath("//button[@ng-click='openAccount()']");
		ActionsClick(openAcc);

		WebElement userSelect = WaitXpath("//select[@id='userSelect']");
		ActionsClickAndHold(userSelect);

		WebElement textName = WaitXpath("//option[text()='Malik Ajay']");
		textName.click();

		WebElement currency = WaitXpath("//select[@id='currency']");
		ActionsClickAndHold(currency);

		WebElement pound = WaitXpath("//option[text()='Pound']");
		pound.click();

		SubmitButtonClick();
		AlertAccept();
	}

	@Test(priority = 2)
	public void GoToCustomerLogin() {
		OpenCustomerAccount();

		HomeButtonClick();

		WebElement customerBut = WaitXpath("//button[@ng-click='customer()']");
		ActionsClick(customerBut);

		WebElement userSelect = WaitXpath("//select[@id='userSelect']");
		ActionsClickAndHold(userSelect);

		WebElement textName = WaitXpath("//option[text()='Malik Ajay']");
		textName.click();

		SubmitButtonClick();
	}

	@Test(priority = 3)
	public void DepositCashWithdraw() {

		GoToCustomerLogin();

		WebElement depositBut = WaitXpath("//button[@ng-click='deposit()']");
		ActionsClick(depositBut);

		WebElement amount = WaitXpath("//input[starts-with(@class,'form-control')]");
		amount.sendKeys("10000");

		SubmitButtonClick();

		WebElement withdrawlBut = WaitXpath("//button[@ng-click='withdrawl()']");
		withdrawlBut.click();

		WebElement amountToWithdraw = WaitXpath("//label[text()='Amount to be Withdrawn :']//following::input");
		amountToWithdraw.sendKeys("2000");

		WebElement withdrawAmountButton = WaitXpath("//button[text()='Withdraw']");
		ActionsClick(withdrawAmountButton);
	}

	@Test(priority = 4)
	public void Transactions() {

		DepositCashWithdraw();

		WebElement transactionsbut = WaitXpath("//button[@ng-click='transactions()']");
		ActionsClick(transactionsbut);

		WebElement startDateTime = WaitXpath("//input[@id='start']");
		startDateTime.sendKeys("2022-08-15T21:33:44");
		WebElement endDateTime = WaitXpath("//input[@id='end']");
		endDateTime.sendKeys("2022-08-17T21:33:44");
	}

	@Test(priority = 5)
	public void ResetTransactionsLogout() {

		Transactions();

		WebElement resetBut = WaitXpath("//button[@ng-click='reset()']");
		ActionsClick(resetBut);

		WebElement logoutBut = WaitXpath("//button[@class='btn logout']");
		ActionsClick(logoutBut);
	}

	@Test(priority = 6)
	public void ManagerLoginDeleteCustomer() {

		ResetTransactionsLogout();

		HomeButtonClick();

		WebElement managerButton = WaitXpath("//button[@ng-click='manager()']");
		ActionsClick(managerButton);

		WebElement showCust = WaitXpath("//button[@ng-click='showCust()']");
		ActionsClick(showCust);

		WebElement delCust = WaitXpath("//input[starts-with(@class,'form-control')]");
		delCust.sendKeys("Malik");

		WebElement delCustBut = WaitXpath("//button[@ng-click='deleteCust(cust)']");
		ActionsClick(delCustBut);
	}

	@AfterTest
	public void quitDriver() {

		driver.quit();
	}

}
