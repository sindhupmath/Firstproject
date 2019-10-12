package net.PHPTravels.PHPTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBookingSearch {
	static Properties p = new Properties();

	 @Test
	public static void main(String[] args) throws IOException, InterruptedException {
	
		// TODO Auto-generated method stub
	

	 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Selenium\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
		p.load(fis);
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		//flight
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		
		
		//enter_location1
	  driver.findElement(By.xpath("//div[@id='s2id_origin']//span[@class='select2-chosen'][contains(text(),'Enter Location')]")).click();
	driver.findElement(By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']")).sendKeys(p.getProperty("source_location"));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']")).sendKeys(Keys.ENTER);
		
		//enter_location2
		driver.findElement(By.xpath("//div[@id='s2id_destination']//span[@class='select2-chosen'][contains(text(),'Enter Location')]")).click();
		driver.findElement(By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']")).sendKeys(p.getProperty("dest_location"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']")).sendKeys(Keys.ENTER);
		
		//Departure
		driver.findElement(By.xpath("//input[@id='departure']")).click();
		String s1=driver.findElement(By.xpath("//input[@id='departure']")).getText();
		while(!s1.equalsIgnoreCase(p.getProperty("dept_date")));
		{
			driver.findElement(By.xpath("//div[16]//div[1]//tr[1]//th[3]")).click();//next
			s1=driver.findElement(By.xpath("//div[16]//div[1]//tr[1]//th[2]")).getText();//month
		}
		String s2;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=7;j++)
			{
				s2=driver.findElement(By.xpath("//div[16]//div[1]//tr["+i+"]//th["+j+"]")).getText();
				if(s2.equals("i"))
					{
					for(int k=1;k<=6;k++)
						{
						for(int x=1;x<=7;x++)
							{
							s2=driver.findElement(By.xpath("//div[16]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(s2);
							if(s2.equals(p.getProperty("//div[16]//tr["+k+"]//td["+x+"]")))
								{
								driver.findElement(By.xpath("d_date")).click();
								}
							}
						}
					}
				}
		}
		//Arrival
		driver.findElement(By.xpath("//input[@id='arrival']")).click();
		String s3=driver.findElement(By.xpath("//input[@id='arrival']")).getText();
		while(!s3.equalsIgnoreCase(p.getProperty("ret_date")));
		{
			driver.findElement(By.xpath("//div[17]//div[1]//tr[1]//th[3]")).click();
			s3=driver.findElement(By.xpath("//div[17]//div[1]//tr[1]//th[2]")).getText();
		}
		String s4;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=7;j++)
			{
				s4=driver.findElement(By.xpath("//div[17]//div[1]//tr["+i+"]//th["+j+"]")).getText();
				if(s4.equals("i"))
					{
					for(int k=1;k<=6;k++)
						{
						for(int x=1;x<=7;x++)
							{
							s4=driver.findElement(By.xpath("//div[17]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(s4);
							if(s4.equals(p.getProperty("//div[17]//tr["+k+"]//td["+x+"]")))
								{
								driver.findElement(By.xpath("a_date")).click();
								}
							}
						}
					}
				}		}
		//guest
		driver.findElement(By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']")).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='madult']")).click();
		driver.findElement(By.xpath("//select[@id='madult']")).sendKeys(p.getProperty("Adult"));
		driver.findElement(By.xpath("//select[@id='mchildren']")).click();
		driver.findElement(By.xpath("//select[@id='mchildren']")).sendKeys(p.getProperty("Child"));
		driver.findElement(By.xpath("//select[@id='minfant']")).click();
		driver.findElement(By.xpath("//select[@id='minfant']")).sendKeys(p.getProperty("Infant"));
		driver.findElement(By.xpath("//button[@id='sumManualPassenger']")).click();
		
		// one way
		driver.findElement(By.xpath("//div[@class='iradio_square-grey']//ins[@class='iCheck-helper']")).click();
		//Round trip
		driver.findElement(By.xpath("//div[@class='iradio_square-grey checked']//ins[@class='iCheck-helper']")).click();
		//search
		driver.findElement(By.xpath("//button[@class='btn-primary btn btn-lg btn-block pfb0']")).click();
		driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
	}
}