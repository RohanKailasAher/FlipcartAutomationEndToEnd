package Base;

import ExtentReports.ExtentReportManager;
import Util.UtilClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass extends ExtentReportManager {
    public static WebDriver driver;
    public static Properties prop;
    UtilClass utilClass;
    @BeforeTest
    public void setup()
    {
        Initialization();
        utilClass = new UtilClass();
        UtilClass. clickCloseButton();

    }

    @AfterTest
    public void teardown ()
    {
        extentReports.flush();
        driver.quit();
    }

    public BaseClass() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/main/java/Config/Config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Initialization() {
        String browserName = prop.getProperty("browser");

        switch (browserName){
            case  "chrome":
                WebDriverManager.chromedriver().setup();
                driver   = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                break;

            default:
                System.out.println("Unsupported browser: " + browserName);

        }
    }

}
