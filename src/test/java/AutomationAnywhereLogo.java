import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereLogo {

    public static void main(String[] args) {
        
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        
        String url = "https://www.automationanywhere.com/";
        driver.get(url);
        driver.manage().window().maximize();
        
        //below statement added to accept Cookies 
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        
        WebElement automationAnywhereLogo = driver.findElement(By.xpath("//a[@class='coh-link header-logo']/img"));
        if(automationAnywhereLogo.isDisplayed())
        {
        	System.out.println("Automation Anywahere Logo is Present");
        }
        else
        {
        	System.out.println("Automation Anywhere Logo not present");
        }
        
        //moving from Home page
        WebElement prductLink = driver.findElement(By.xpath("//a[text()='Products']"));
        prductLink.click();
        
        WebElement requestDemoButtom = driver.findElement(By.xpath("//a[text()='Request Demo']"));
        
        if(requestDemoButtom.isEnabled())
        {
        	System.out.println("Request Demo button is Clickable");
        }
        
        else
        {
        	System.out.println("Request Demo button is no Clickable");
        }
        
        driver.quit();
    }
}