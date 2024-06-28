package WebDriverStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chrome {
    public static WebDriver driver;

       @Test
       public void LaunchBrowser(){
           driver = new ChromeDriver();
           driver.get("https://www.amazon.in/");
           driver.close();
       }

}
