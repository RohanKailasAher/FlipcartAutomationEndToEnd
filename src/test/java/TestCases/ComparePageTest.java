package TestCases;


import Base.BaseClass;
import ExtentReports.ExtentReportManager;
import Scenarios.ComparePage;
import Scenarios.SearchPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ExtentReportManager.class})
public class ComparePageTest extends BaseClass {

    SearchPage searchPage;
    ComparePage comparePage;

    @Test(description = "Verify Selecting the Product Brand", priority = 1)
    public void verifySelectBrand() {
        startTest("Verify Selecting the Product Brand", "Rohan Aher", "Smoke Test");

        try {
            searchPage =new SearchPage();
            extentTest.log(Status.INFO, "Verify selecting the product brand.");
            searchPage.selectBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Clicking on All Checkboxes", priority = 2, dependsOnMethods = "verifySelectBrand")
    public void verifyClickOnAllCheckboxes() throws InterruptedException {
        startTest("Verify Clicking on All Checkboxes", "Rohan Aher", "Smoke Test");

        try {
            searchPage =new SearchPage();
            extentTest.log(Status.INFO, "Verify clicking on all checkboxes.");
            searchPage.clickOnAllCheckboxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify Clicking on Apply", priority = 3, dependsOnMethods = "verifyClickOnAllCheckboxes")
    public void verifyClickOnApply() throws InterruptedException {
        startTest("Verify Clicking on Apply", "Rohan Aher", "Smoke Test");

        try {
            searchPage =new SearchPage();
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
            searchPage =new SearchPage();
            extentTest.log(Status.INFO, "Verify clicking on 'Newest First'.");
            searchPage.clickOnNewestFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Verify the Compare Button Functionality", priority = 5, dependsOnMethods = "verifyClickOnNewestFirst")
    public void verifyCompareButton() throws InterruptedException {
        startTest("Verify the Compare Button Functionality", "Rohan Aher", "Smoke Test");

        try {
            searchPage =new SearchPage();
            extentTest.log(Status.INFO, "Verify the Compare button functionality.");
            searchPage.CompareButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(description = "Verify the Display of Number of Items After Using Compare Button", priority = 6, dependsOnMethods = "verifyCompareButton")
    public void verifyNumberOfItemsDisplayedAfterComparison(){
        startTest("Verify the Display of Number of Items After Using Compare Button", "Rohan Aher", "Smoke Test");

        try {
            comparePage = new ComparePage();
            extentTest.log(Status.INFO, "Verify the display of the number of items after using the Compare button.");
            comparePage.isNoOfItemsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


