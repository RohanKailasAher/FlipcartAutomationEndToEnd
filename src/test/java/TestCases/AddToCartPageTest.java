package TestCases;

import Base.BaseClass;
import ExtentReports.ExtentReportManager;
import Scenarios.AddToCartPage;
import Scenarios.ComparePage;
import Scenarios.SearchPage;
import Util.MyScreenRecorder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExtentReportManager.class})
public class AddToCartPageTest extends BaseClass {
    SearchPage searchPage;
    ComparePage comparePage;
    AddToCartPage addToCartPage;

    @Test(description = "Verify Selecting the Product Brand", priority = 1)
    public void verifySelectBrand() {
        try {
            // Start recording
            MyScreenRecorder.startRecording("VerifySelectBrand");

            startTest("Verify Selecting the Product Brand", "Suman", "Sanity Test");
            searchPage = new SearchPage();
            extentTest.log(Status.INFO, "Verify selecting the product brand.");
            searchPage.selectBrand();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Stop recording
                MyScreenRecorder.stopRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test(description = "Verify Clicking on All Checkboxes", priority = 2, dependsOnMethods = "verifySelectBrand")
    public void verifyClickOnAllCheckboxes() throws InterruptedException {
        startTest("Verify Clicking on All Checkboxes", "Rohan Aher", "Smoke Test");

        try {
            searchPage = new SearchPage();
            extentTest.log(Status.INFO, "Verify clicking on all checkboxes.");
            searchPage.clickOnAllCheckboxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Clicking on Apply", priority = 3, dependsOnMethods = "verifyClickOnAllCheckboxes")
    public void verifyClickOnApply() throws InterruptedException {
        startTest("Verify Clicking on Apply", "Suman", "Smoke Test");

        try {
            searchPage = new SearchPage();
            extentTest.log(Status.INFO, "Verify clicking on the Apply button.");
            searchPage.clickOnApply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Clicking on Newest First", priority = 4, dependsOnMethods = "verifyClickOnApply")
    public void verifyClickOnNewestFirst() throws InterruptedException {
        startTest("Verify Clicking on Newest First", "Rohan Aher", "Smoke Test");

        try {
            searchPage = new SearchPage();
            extentTest.log(Status.INFO, "Verify clicking on 'Newest First'.");
            searchPage.clickOnNewestFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify the Compare Button Functionality", priority = 5, dependsOnMethods = "verifyClickOnNewestFirst")
    public void verifyCompareButton() throws InterruptedException {
        startTest("Verify the Compare Button Functionality", "Vaibhav", "Sanity Test");

        try {
            searchPage = new SearchPage();
            extentTest.log(Status.INFO, "Verify the Compare button functionality.");
            searchPage.CompareButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify the Display of Number of Items After Using Compare Button", priority = 6, dependsOnMethods = "verifyCompareButton")
    public void verifyNumberOfItemsDisplayedAfterComparison() {
        startTest("Verify the Display of Number of Items After Using Compare Button", "Rohan Aher", "Smoke Test");

        try {
            comparePage = new ComparePage();
            extentTest.log(Status.INFO, "Verify the display of the number of items after using the Compare button.");
            comparePage.isNoOfItemsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(description = "Verify Adding a Phone to the Cart", priority = 7)
    public void verifyAddToCart() {
        startTest("Verify Adding a Phone to the Cart", "Vaibhav", "Sanity Test");

        try {
            addToCartPage = new AddToCartPage();
            extentTest.log(Status.INFO, "Click on the phone to add it to the cart.");
            addToCartPage.ClickOnPhone();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Viewing Ratings and Reviews", priority = 8, dependsOnMethods = "verifyAddToCart")
    public void verifyRatingsAndReviews() throws InterruptedException {
        startTest("Verify Viewing Ratings and Reviews", "Rohan Aher", "Smoke Test");

        try {
            extentTest.log(Status.INFO, "View ratings and reviews of the phone.");
            addToCartPage.RatingsAndReviews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Adding the Phone to Cart", priority = 9, dependsOnMethods = "verifyRatingsAndReviews")
    public void verifyAddToCartAgain() throws InterruptedException {
        startTest("Verify Adding the Phone to Cart Again", "Rohan Aher", "Smoke Test");

        try {
            extentTest.log(Status.INFO, "Add the phone to the cart.");
            addToCartPage.AddToCart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Price Details Displayed", priority =10, dependsOnMethods = "verifyAddToCartAgain")
    public void verifyPriceDetailsDisplay() {
        startTest("Verify Price Details Displayed", "Vaibhav", "Sanity");

        try {
            extentTest.log(Status.INFO, "Verify that price details are displayed.");
            addToCartPage.displayPriceDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Price Calculations", priority = 11, dependsOnMethods = "verifyPriceDetailsDisplay")
    public void verifyPriceCalculations() {
        startTest("Verify Price Calculations", "Vaibhav", "Sanity Test");

        try {
            extentTest.log(Status.INFO, "Verify the price calculations.");
            addToCartPage.validateCalculations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 13)
    public void testNullPointerExcep(){
        startTest("Test null pointer exception.", "Naresh", "Regression");
        extentTest.log(Status.INFO, "Validate value should not null");
        String val = null;

        if(val.equals("Test")){
            extentTest.log(Status.PASS, "Value is Test");
        }
        else{
            extentTest.log(Status.FAIL, "Validate value is null");
        }
    }
    @Test(priority = 14)
    public void testArithmaticExcep(){
        startTest("test Arithmatic Exception.", "Naresh", "Regression");
        extentTest.log(Status.INFO, "take input value");
        int val = 10/0;
        System.out.println("value"+val);

    }
}
