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

public class HotelBookingSearch {
	static Properties p = new Properties();
	
@Test
	public void HotelBookingSearch() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("C:\\Selenium\\PHPTravels\\src\\main\\java\\net\\PHPTravels\\PHPTravels\\data.properties");
		p.load(fis);
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']")).click();
		driver.findElement(By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']")).sendKeys(p.getProperty("Hotel_name"));
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']")).sendKeys(Keys.ENTER);
		
	
		//check_in
		driver.findElement(By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']")).click();
		String s2 =driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[2]")).getText();//month
	
		
		while(!s2.equalsIgnoreCase(p.getProperty("Check_in")))
		{
			driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[3]")).click();//next
			s2=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();//month
			
		}
		String s1;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=7;j++)
			{
			 s1=driver.findElement(By.xpath("//div[14]//tr["+i+"]//td["+j+"]")).getText();//date
				if(s1.equals("1"))
				{
					for(int k=1;k<=6;k++)
					{
						for(int x=1;x<=7;x++)
							
						{
							s1 = driver.findElement(By.xpath("//div[14]//tr["+k+"]//td["+x+"]")).getText();
							System.out.println(s1);
							if(s1.equals(p.getProperty("indate")))
							{
								driver.findElement(By.xpath("//div[14]//tr["+k+"]//td["+x+"]")).click();
								
							}
							
						}
					}
				}
			}
		}
		//checkout
		//driver.findElement(By.xpath("//input[@placeholder='Check_out']")).click();
		String s3 = driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();//month
		
		
		while(!s3.equalsIgnoreCase(p.getProperty("Check_out")))
		{
			driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();//next
			s3 = driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();//month
	    }
		String s4;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=7;j++)
			{
			 s4 =driver.findElement(By.xpath("//div[15]//tr["+i+"]//td["+j+"]")).getText();
			 if(s4.equals("1"))
			 {
				for(int k=1;k<=6;k++)
				{
					for(int x=1;x<=7;x++)
					{
						s4 =driver.findElement(By.xpath("//div[15]//tr["+k+"]//td["+x+"]")).getText();
						System.out.println(s4);
						if(s4.equals(p.getProperty("outdate")))
						{
							driver.findElement(By.xpath("//div[15]//tr["+k+"]//td["+x+"]")).click();
						}
					}
				}
			}
		 }
	}
				//guest details
				driver.findElement(By.xpath("//input[@id='htravellersInput']")).click();
				driver.findElement(By.xpath("//input[@id='hadultInput']")).clear();
				driver.findElement(By.xpath("//input[@id='hadultInput']")).sendKeys(p.getProperty("adult"));
				driver.findElement(By.xpath("//input[@id='hchildInput']")).sendKeys(p.getProperty("child"));
				driver.findElement(By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
				
				
				
				
				
				
					
	}
				
}
		
		
	


