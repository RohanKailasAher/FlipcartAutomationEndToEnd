package WebDriverWithoutStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class edge {
    public WebDriver driver;
    @Test
    public void LaunchBrowser(){
        driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.close();
    }

}
