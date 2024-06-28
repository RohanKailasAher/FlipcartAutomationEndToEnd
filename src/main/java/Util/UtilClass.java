package Util;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UtilClass extends BaseClass {
    public UtilClass() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@role='button']")
    public static WebElement closeButton;
    // Click on Element
    public static void clickCloseButton() {
        closeButton.click();
    }
}
