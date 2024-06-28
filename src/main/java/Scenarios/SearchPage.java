package Scenarios;


import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class SearchPage extends BaseClass {
    @FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
    WebElement SearchBar;

    @FindBy(xpath = "//div[@class='_2RTO7p'] //div[@class='_24_Dny']")
    List<WebElement> chkboxes;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SearchIcon;

    @FindBy(xpath = "//span[text()='Apply Filters']")
    WebElement ApplyBtn;

    @FindBy(xpath = "//div[@class='QvtND5 _2w_U27']")
    WebElement SeeMore;
    @FindBy(xpath = "//div[text()='Newest First']")
    WebElement NewestFirst;
    @FindBy(xpath = "//span[@class='f3A4_V']")
    List<WebElement> ListCheckBox;
    @FindBy(css = "._11o22n._87aCMT")
    WebElement CompareButton;


    public SearchPage() //constructor
    {
        PageFactory.initElements(driver, this); //we will called using this //all element initilaized by driver
    }


    public void selectBrand() {
        SearchBar.sendKeys(prop.getProperty("Product"));
        SearchIcon.click();
        SeeMore.click();

    }

    public void clickOnAllCheckboxes() throws InterruptedException {
        int size = chkboxes.size();
        System.out.println(size);
        for (int i = 0; i <3; i++) {
            chkboxes.get(i).click();
            Thread.sleep(3000);
        }

    }
    public void clickOnApply() throws InterruptedException {
        ApplyBtn.click();
        Thread.sleep(3000);

    }
    public void clickOnNewestFirst() throws InterruptedException {
        NewestFirst.click();
        Thread.sleep(3000);

    }
    public void CompareButton()
    {
        for (int i = 1; i < 4; i++) {
            ListCheckBox.get(i).click();
        }
        CompareButton.click();
    }
}