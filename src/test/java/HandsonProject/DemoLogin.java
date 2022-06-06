package HandsonProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoLogin

{
	public static void main (String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver.get("http://demowebshop.tricentis.com/login");
	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		driver.findElement(By.id("Email")).sendKeys("sratnappagol3@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Ganu@123");

        driver.findElement(By.xpath("//*[@value='Log in']")).click();
        driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys("health book");
        driver.findElement(By.xpath("//*[@value='Search']")).click();
        
        driver.findElement(By.xpath("//*[@class='button-2 product-box-add-to-cart-button']")).click();
        Thread.sleep(6000);
       
         driver.findElement(By.xpath("//*[text()='Shopping cart']")).click();
         Thread.sleep(5000);
         
         Select s1=new Select(driver.findElement(By.xpath("//*[@name='CountryId']")));
          s1.selectByVisibleText("India");
         Thread.sleep(5000);
         driver.findElement(By.id("ZipPostalCode")).sendKeys("560102");
         driver.findElement(By.xpath("//*[@value='Estimate shipping']")).click();
         driver.findElement(By.xpath("//*[@name='termsofservice']")).click();
         driver.findElement(By.xpath("//*[@name='checkout']")).click();
        
         driver.findElement(By.xpath("(//*[@title='Continue'])[1]")).click();
         driver.findElement(By.xpath("(//*[@name='PickUpInStore'])[1]")).click();
         driver.findElement(By.xpath("(//*[@title='Continue'])[2]")).click();
         driver.findElement(By.xpath("(//*[@value='Continue'])[4]")).click();
         driver.findElement(By.xpath("(//*[@value='Continue'])[5]")).click();
	}
}
