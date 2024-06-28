package WebDriverStatic;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class edge extends chrome{

    @Test
    public void LaunchBrowser(){
        driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.close();
    }

}
