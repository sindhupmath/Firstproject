package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {
	
 static Properties p = new Properties();
 
	public static void main(String[] args) throws IOException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	FileInputStream fis = new FileInputStream("C:\\Selenium\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
	p.load(fis);
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")).click();
	driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]")).click();
	driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[3]/input")).sendKeys(p.getProperty("First_name"));
	driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[4]/input")).sendKeys(p.getProperty("Last_name"));
	driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(p.getProperty("mobile_number"));
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(p.getProperty("Email"));
	driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[7]/input")).sendKeys(p.getProperty("password"));
	driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/input")).sendKeys(p.getProperty("confirm_password"));
	driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
	driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();

	}

}