package WebDriverWithoutStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chrome {
    public WebDriver driver;

    @Test
    public void LaunchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.close();
    }

}
