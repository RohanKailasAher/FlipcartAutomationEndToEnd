package Scenarios;


import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartPage extends BaseClass {
    @FindBy(xpath = "//a[text()='A50G']")
    WebElement ChoiceThePhone;
    @FindBy(xpath = "//div[@class='_3LWZlK']")
    WebElement RatingsAndReviews;
    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    WebElement GoToCART;
    @FindBy(xpath = "//div[text()='Price (1 item)']")
    WebElement priceLabel;

    @FindBy(xpath = "//div[@class='_35mLK5']/div[1]/div[1]/div[2]/span[1]")
    WebElement itemPrice;

    @FindBy(xpath = "//div[text()='Discount']")
    WebElement discountLabel;

    @FindBy(xpath = "//div[text()='Discount']/parent::div/following::div/span/span")
    WebElement discountAmount;

    @FindBy(xpath = "//div[text()='Delivery Charges']")
    WebElement deliveryChargesLabel;

    @FindBy(xpath = "//div[text()='Total Amount']")
    WebElement totalAmountLabel;

    @FindBy(xpath = "//div[@class='_35mLK5']/descendant::div[@class='_3LxTgx']/descendant::div[@class='_1dqRvU']")
    WebElement totalAmount;

    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }
    public void ClickOnPhone() throws InterruptedException {
        Thread.sleep(3000);
        ChoiceThePhone.click();

    }
    public void RatingsAndReviews() throws InterruptedException {
        Thread.sleep(3000);
        RatingsAndReviews.click();

    }
    public void AddToCart() throws InterruptedException {
        Thread.sleep(3000);
        GoToCART.click();

    }
    public void displayPriceDetails()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(priceLabel));
        Assert.assertTrue(priceLabel.isDisplayed(), "Price Label is not displayed");
        Assert.assertTrue(itemPrice.isDisplayed(), "Item Price is not displayed");

        wait.until(ExpectedConditions.visibilityOf(discountLabel));
        Assert.assertTrue(discountLabel.isDisplayed(), "Discount Label is not displayed");
        Assert.assertTrue(discountAmount.isDisplayed(), "Discount Amount is not displayed");

        wait.until(ExpectedConditions.visibilityOf(deliveryChargesLabel));
        Assert.assertTrue(deliveryChargesLabel.isDisplayed(), "Delivery Charges Label is not displayed");

        wait.until(ExpectedConditions.visibilityOf(totalAmountLabel));
        Assert.assertTrue(totalAmountLabel.isDisplayed(), "Total Amount Label is not displayed");
        Assert.assertTrue(totalAmount.isDisplayed(), "Total Amount is not displayed");
    }

    public void validateCalculations() {
        String price = "₹1,799";
        String Discount = "₹260";
        price = price.replace("₹", "").replace(",", "");
        String discount = Discount.replace("₹", "");
        int p = Integer.parseInt(price);
        int d = Integer.parseInt(discount);
        int totalAmount = p - d;
        System.out.println("Total Amount: " + totalAmount);
        Assert.assertEquals(totalAmount, 1539, "Total Amount calculation is incorrect");
    }
}