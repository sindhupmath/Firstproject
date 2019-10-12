package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExistingUserLogin {

	public static void main(String[] args) throws IOException {
	Properties p = new Properties();
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("C:\\Selenium\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
	p.load(fis);
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")).click();
	driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")).sendKeys(p.getProperty("Email"));
	driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")).sendKeys(p.getProperty("password"));
	driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();

	}

}
