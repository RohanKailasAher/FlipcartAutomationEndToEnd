package Scenarios;


import Base.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage extends BaseClass {
    @FindBy(xpath = "//span[text()='3 items']")
    WebElement NoOfItems;

    public ComparePage() //constructor
    {
        PageFactory.initElements(driver, this); //we will called using this //all element initilaized by driver
    }

    public boolean isNoOfItemsDisplayed() {
        try {
            return NoOfItems.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }




}
