package TestCases;


import Base.BaseClass;
import ExtentReports.ExtentReportManager;
import Scenarios.SearchPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;

@Listeners({ExtentReportManager.class})
public class SearchPageTest extends BaseClass {

    public SearchPage searchPage;

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
}