import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageNavigationCheck 
{

	
	
    public void main(String[] args) 
    {
    	String expectedTitle = null;
    	
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        
        String url = "https://www.automationanywhere.com/";
        driver.get(url);
        driver.manage().window().maximize();
        
        //below statement added to accept Cookies 
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        
        String[] linksToVerify = {
            "Products",
            "Solutions",
            "Resources",
            "Beyond RPA",
            "Company"
        };

        for (String linkText : linksToVerify) 
        {
        
        	WebElement linkElement = driver.findElement(By.linkText(linkText));
            
            if (linkElement.isDisplayed()) 
            {
                System.out.println(linkText + " link is present on the homepage.");
                
                linkElement.click();
                
                if(linkText.equalsIgnoreCase("Products"))
                {
                	expectedTitle = "Scale Your Business with Enterprise Automation | AutomationAnywhere.com";
                }
                else if(linkText.equalsIgnoreCase("Solutions"))
                {
                	expectedTitle = "Tailored Automation Solutions | AutomationAnywhere.com";
                }
                else if(linkText.equalsIgnoreCase("Resources"))
                {
                	expectedTitle = "Automation Resources | Learn from the Experts at Automation Anywhere";
                }
                else if(linkText.equalsIgnoreCase("Beyond RPA"))
                {
                	expectedTitle = "Optimize Efficiency with Business Process Automation | AutomationAnywhere.com";
                }
                else if(linkText.equalsIgnoreCase("Company"))
                {
                	expectedTitle = "Intelligent Automation Companies | Meet the Team | Automation Anywhere";
                }
                System.out.println("Actual Title : "+driver.getTitle());
                if (driver.getTitle().equals(expectedTitle)) 
                {
                    System.out.println(linkText + " link navigated to the proper page.");
                    System.out.println();
                } 
                else 
                {
                    System.out.println(linkText + " link did not navigate to the proper page.");
                }
                
                driver.navigate().back();
            } 
            else 
            {
                System.out.println(linkText + " link is not present on the homepage.");
            }
        }

       driver.quit();
    }
}